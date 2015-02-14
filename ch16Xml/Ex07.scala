package ch16Xml

import scala.xml._

object Ex07 extends App {
  def transform(m: Map[String, String]) = {
    <dl>{for (i <- m) yield <dt>{i._1}</dt><dd>{i._2}</dd>}</dl>
  }
  
  println(transform(Map("A" -> "1", "B" -> "2")))
}