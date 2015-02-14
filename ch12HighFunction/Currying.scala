package ch12HighFunction

object Currying extends App {
  def mul(x: Int, y: Int) = x * y
  
  def mulOneAtATime(x: Int) = (y: Int) => x * y
  mulOneAtATime(6)(7)
  def sMulOneAtATime(x: Int)(y: Int) = x * y
  
  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  a.corresponds(b)(_.equalsIgnoreCase (_))
}