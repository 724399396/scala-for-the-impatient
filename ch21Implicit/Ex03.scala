package ch21Implicit

import scala.collection.immutable.Range.Inclusive

object Ex03 extends App {
  implicit def richInt2Factorial(from: Int) = new Factorial(1.to(from))

  println(5!)
}

class Factorial(lst: Inclusive) {
  def ! = lst.reduce(_ * _)
}
