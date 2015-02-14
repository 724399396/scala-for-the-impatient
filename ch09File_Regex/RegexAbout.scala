package ch09File_Regex

import scala.util.matching.Regex

object RegexAbout extends App {
  val numPattern = "[0-9]+".r

  val wsnumwsPattern = """\s[0-9]+\s+""".r

  for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles"))
    println(matchString)

  val matches = numPattern.findAllIn("99 bottles, 98 bottles").toArray
  println(matches.mkString(","))

  val m1 = wsnumwsPattern.findFirstIn("99 bottles, 98 bottles")
  println(m1)
  
  // start part
  val ns = numPattern.findPrefixOf("99 bottles, 98 bottles")
  println(ns)
  val ws = wsnumwsPattern.findPrefixOf("99 bottles, 98 bottles")
  println(ws)
  
  // replace
  numPattern.replaceFirstIn("99 bottles, 98 bottles", "XX")
  numPattern.replaceAllIn("99 bottles, 98 bottles", "XX")
  
  // group
  val numitemPattern = "([0-9]+) ([a-z]+)".r
  val numitemPattern(num, item) = "99 bottles"
  // set num = 99 , item = bottles
  for (numitemPattern(num, item) <- numitemPattern.findAllIn("99 bottels, 98 bottels"))
    println(num + " -- " + item)
    
}