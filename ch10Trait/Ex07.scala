package ch10Trait

trait Fly {
  def fly() {
    println("flying")
  }
  
  def flywithnowing()
}

trait Walk {
  def walk() {
    println("walk")
  }
}

class Bird {
  var name: String = _
}

class BlueBird extends Bird with Fly with Walk {
  def flywithnowing {
    println("BlueBird flywithnowing")
  }
}

object Ex07 extends App {
  val b = new BlueBird
  b.walk()
  b.flywithnowing()
  b.fly
}