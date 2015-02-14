package ch09File_Regex

import scala.io.Source

object Ex03 extends App {
  for (word <- Source.fromFile("1.txt").mkString.split("\\s+")) if (word.length() > 4) println(word) else ()
}