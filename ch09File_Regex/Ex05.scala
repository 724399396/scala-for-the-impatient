package ch09File_Regex

import java.io.{PrintWriter, File}

object Ex05 extends App {
  val a: Array[String] = new Array(21)
  val b: Array[String] = new Array(21)
  for (i <- 0 to 20) {
    val temp = scala.math.pow(2, i)
    a(i) =  temp.toInt.toString(); b(i) = (1 / temp).toString()
  }
  val len = (a.maxBy { i => i.length }.length) + 2
  val out = new PrintWriter(new File("2^n.txt"))
  for (i <- 0 to 20) {
    out.println(a(i) + " " * (len - a(i).length()) + b(i))
  }
  out.close
}