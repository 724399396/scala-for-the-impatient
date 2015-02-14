package ch14Match

object Ex03 extends App {
  def swap(a: Array[Int]): Array[Int] = {
    a match {
      case Array(i, j, k @ _*) => Array(j, i) ++ k
      case _ => a
    }
  }
  
  println(swap(Array(1, 2, 3, 4)).mkString(","))
  println(swap(Array(1,2)).mkString(","))
  println(swap(Array(1)).mkString(","))
}