package ch21Implicit

object Ex02 extends App {
  implicit def int2Percent(from: Int) = new Percent(from)

  println(120 +% 10)
}

class Percent(val now: Int) {
  def +%(x: Int): Int = {
    now *  x / 100 + now
  }
}
