package ch12HighFunction

object Ex02 extends App {
  val max = Array(25,1,21,4,5,9,-9,2,48,21,32).reduceLeft((a,b) => if(a >= b) a else b)
  println(max)
}