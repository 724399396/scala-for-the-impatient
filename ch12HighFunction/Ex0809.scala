package ch12HighFunction

object Ex0809 extends App {
  val a = Array("Hello", "World")
  val b = Array(5, 4)
  val tf = a.corresponds(b) (_.length == _)
  println(tf)
}