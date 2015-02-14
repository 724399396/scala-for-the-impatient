package ch14Match

object Ex02 extends App {
  def swap(t: Tuple2[Int, Int]): Tuple2[Int, Int]  = {
    t match {
      case (y, x) => (x, y)
    }
  }
  
  println(swap((2, 5)))
}