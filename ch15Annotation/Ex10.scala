package ch15Annotation

object Ex10 {
  def factorial(n: Int) = {
    assert(n > 0)
    n
  }
  
  def main(args: Array[String]) {
    factorial(-1)
  }
}