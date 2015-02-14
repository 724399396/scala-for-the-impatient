package ch12HighFunction

object Ex04 extends App {
  def factorial(n: Int) = {
    (1 to n).foldLeft[Int](1)(_ * _)
  }
}