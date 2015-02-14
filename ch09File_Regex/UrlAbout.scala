package ch09File_Regex

import scala.io.Source

object UrlAbout extends App {
  val source1 = Source.fromURL("http://www.baidu.com", "UTF-8")
  println(source1.mkString)
  val source2 = Source.fromString("Hello, World!")
  // can help debug
  val source3 = Source.stdin
  // read from standard
}