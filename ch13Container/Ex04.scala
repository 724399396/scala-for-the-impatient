package ch13Container

object Ex04 extends App {
  def change(strs: Set[String], m: Map[String, Int]) = {
    strs.flatMap { x => m.get(x) }
  }
  
  println(change(Set("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)))
}