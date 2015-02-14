package ch09File_Regex

import scala.io.Source

object FileAbout extends App {
  // only use once , like a stream
  val source = Source.fromFile("1.txt", "UTF-8")
  //first arg is string or java.io.File
  // if you know the character is default, you can ignore the second arg
  val lineIterator = source.getLines

  for (i <- lineIterator)
    println(i)
  // read as string
  val contents = source.mkString
  println(contents)
  // read as character
  for (ch <- source) print(ch + " ")
  // read and split
  val tokens = source.mkString.split("\\t")
  // read and transfer to AnyVal
  val numbers = for (w <- tokens) yield w.toDouble
  val numbers2 = tokens.map(_.toDouble)
  source.close
  // read and put back
  val source2 = Source.fromFile("1.txt")
  val iter = source2.buffered
  while (iter.hasNext) {
    if (iter.head == 'a')
      print(iter.next + " ")
    else iter.next
  }
  source2.close
  
  // Console
  print("How old are you")
  
  val age = readInt()
}