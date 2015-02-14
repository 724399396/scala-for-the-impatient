package ch18HighType

import scala.collection.mutable.ArrayBuffer

trait Listener[S, E <: Event[S]] {
  def occurred(e: E): Unit
}

trait Source[S, E <: Event[S], L <: Listener[S, E]] {
  this: S =>
  private val listeners = new ArrayBuffer[L]
  def add(l: L) { listeners += l}
  def remove(l: L) { listeners -= l}
  def fire(e: E): Unit = {
    e.source = this
    for (l <- listeners) l.occurred(e)
  }
}

class ButtonEvent extends Event[Button]

trait ButtonListener extends Listener[Button, ButtonEvent]

class Button extends Source[Button, ButtonEvent, ButtonListener] {
  def click(): Unit = {
    fire(new ButtonEvent)
  }
}

trait Event[S] {
  var source: S = _
}

object Polymorphic {

}


trait ListenerSupport {
  type S <: Source
  type E <: Event
  type L <: Listener

  trait Event {
    var source: S = _
  }

  trait Listener {
    def occurred(e: E) {}
  }

  trait Source {
    this: S =>
    private val listeners = new ArrayBuffer[L]
    def add(l: L) { listeners += l }
    def remove(l: L) { listeners -= l }
    def fire(e: E): Unit = {
      e.source = this
      for (l <- listeners) l.occurred(e)
    }
  }
}

object ButtonModule extends ListenerSupport {
  type S = Button
  type E = ButtonEvent
  type L = ButtonListener

  class ButtonEvent extends Event
  class ButtonListener extends Listener
  class Button extends Source {
    def click() { fire(new ButtonEvent) }
  }
}