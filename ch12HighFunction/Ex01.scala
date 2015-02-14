package ch12HighFunction

object Ex01 extends App {
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for(i <- low to high) yield (i -> fun(i))
  }
  println(values(x => x * x, -5, 5).mkString(", "))
}