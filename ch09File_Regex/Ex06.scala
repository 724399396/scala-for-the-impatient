package ch09File_Regex

import scala.util.matching.Regex

object Ex06 extends App {
  val symbol = """[\w\s]+"[\w\s]+""".r
  println(symbol.findFirstIn("like this, maybe with \" or \\"))
}