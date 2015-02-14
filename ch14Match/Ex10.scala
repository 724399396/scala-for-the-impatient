package ch14Match

import scala.math.sqrt

object Ex10 extends App {
  def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  def compose(f1: Double => Option[Double], f2: Double => Option[Double]) = {
    (x :Double) =>
      if (f(x) == None || g(x) == None) None
      else g(x)
  }
  val h = compose(f, g)
  
  println(h(2))
}