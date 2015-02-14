package ch12HighFunction

object Ex06 extends App {
  def largestAt(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.reduceLeft((a,b) => if(fun(a) > fun(b)) a else b)
  }
  
    println(largestAt(x => 10 * x - x * x, 1 to 10))
}