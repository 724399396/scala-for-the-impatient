package ch09File_Regex

object Ex01 extends App {
  import scala.io.Source
  import scala.collection.mutable.ArrayBuffer
  import java.io.{PrintWriter, File}
  val source = Source.fromFile("numbers.txt")
  val lineIterator = source.getLines
  val strs: ArrayBuffer[String] = ArrayBuffer() 
  for(l <- lineIterator)
    strs += l
  val out = new PrintWriter(new File("numbers.txt"))
  out.println(strs.reverse.mkString("\r\n"))
  out.close()
}