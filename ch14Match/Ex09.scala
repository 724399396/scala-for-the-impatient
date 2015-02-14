package ch14Match

object Ex09 extends App {
  def sum(lst: List[Option[Int]]): Int = {
    lst.foldLeft(0)(_ + _.getOrElse(0))
  }
  val l : List[Option[Int]] = List(Option(-1),None,Option(2))
  
  println(sum(l))
}