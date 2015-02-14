package ch09File_Regex

import scala.io.Source
import java.io.{File, FileWriter}

object Ex02 extends App {
  val filePath = "1.txt"
  val source = Source.fromFile(filePath)
  val contents = source.mkString.split("\t").toArray
  val out = new FileWriter(new File(filePath), true)
  out.write(contents.mkString(" "))
  out.close()
}