package ch13Container

object WhyImmutable extends App {
  def digits(n: Int): Set[Int] = {
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n / 10) + (n % 10)
  }
}