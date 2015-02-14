package ch20Actor
import scala.actors.Actor
import scala.actors.Actor._
import scala.collection.mutable.ArrayBuffer

object Ex06 extends App {
  var a = new ArrayBuffer[Actor]()
  var i = 10
  while(i >0) {
    a :+= actor {
      while(true)
        receive {
          case "Hello" => println("while: " + Thread.currentThread())
        }
    }
    a :+= actor {
      loop {
        react {
          case "Hello" => println("loop: " + Thread.currentThread())
        }
      }
    }
    i -= 1
  }
  a.foreach { x => x.start(); x ! "Hello" }
}
