package ch12HighFunction

object Ex07 extends App {
  def adjustToPair(fun : (Int, Int) => Int) = {
    (x: Tuple2[Int, Int]) => fun(x._1, x._2)
  }
  
  println(adjustToPair(_ * _) ((6, 7)))
  
  val pairs = (1 to 10) zip (11 to 20)
  println(pairs.map(adjustToPair(_ * _)))
}