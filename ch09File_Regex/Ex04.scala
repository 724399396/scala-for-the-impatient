package ch09File_Regex

import scala.io.Source

object Ex04 extends App {
  val nums: Array[Int] = for( num <- Source.fromFile("1Kints.txt").mkString.trim.split("\\s+") ) yield num.trim.toInt
  println("Sum: " + nums.sum)
  println("Average: " + (nums.sum / nums.size))
  println("Max: " + nums.max)
  println("Min: " + nums.min)
}