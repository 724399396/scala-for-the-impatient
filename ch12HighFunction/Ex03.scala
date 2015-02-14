package ch12HighFunction

object Ex03 extends App {
  def factorial(n: Int) = {
    (1 to n).reduceLeft(_ * _)
  }
  
  println(factorial(3))
}