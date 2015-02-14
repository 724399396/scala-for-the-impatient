package ch13Container

object Ex05 extends App {
  def myMkString(lst: Array[String], partition: String) :String= {
    lst.reduceLeft((a,b) => (a+ partition  + b))
  }
  println(myMkString(Array("1", "5", "4", "2"), ","))
}