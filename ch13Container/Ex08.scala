package ch13Container

object Ex08 extends App {
  def v1tov2(primaryArray: Array[Double], i: Int): Array[Array[Double]] = {
   val temp =  for (a <- primaryArray.grouped(i)) yield ( for(e <- a) yield e)
   temp.toArray
  }
  
  v1tov2(Array(1, 2, 3, 4, 5, 6), 3).foreach(a => println(a.mkString(",")))
}