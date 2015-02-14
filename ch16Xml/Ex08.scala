package ch16Xml

import scala.xml._

object Ex08 extends App {
  def transform(s: NodeSeq): Map[String, String] = {
    var m: Map[String, String] = Map()
    for (i <- (s \ "dt").toList.zip((s \ "dd").toList))
      m += (i._1.text -> i._2.text)
    m
  }
  val item = <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>
  println(transform(item))
}