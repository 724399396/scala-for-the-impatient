package ch09File_Regex

import java.io.{File, FileInputStream}

object BinaryAbout extends App {
  val file = new File("1.txt")
  val in = new FileInputStream(file)
  val bytes = new Array[Byte](file.length.toInt)
  in.read(bytes)
  println(bytes.mkString)
  in.close
}