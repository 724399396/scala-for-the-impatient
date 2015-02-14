package ch15Annotation
import annotation.varargs

class Ex04 {
  @varargs
  def sum(n: Int*) = {
    n.sum
  }
}
