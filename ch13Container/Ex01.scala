package ch13Container
import scala.collection.mutable

object Ex01 extends App {
  def fun(str: String): Map[Char, mutable.ArrayBuffer[Int]] = {
    var index = -1
    (Map[Char, mutable.ArrayBuffer[Int]]() /:str) {
      (m, c) => index += 1; m + (c -> (m.getOrElse(c, mutable.ArrayBuffer()) += index))
    }
  }
  
  println(fun("Mississippi"))
}