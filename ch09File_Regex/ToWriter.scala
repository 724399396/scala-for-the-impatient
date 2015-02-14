package ch09File_Regex

import java.io.PrintWriter

object ToWriter extends App {
  val out = new PrintWriter("numbers.txt")
  for (i <- 1 to 100) out.println(i)
  out.close
}