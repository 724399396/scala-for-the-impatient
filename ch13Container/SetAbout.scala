package ch13Container

object SetAbout extends App {
  val weekdays = scala.collection.mutable.LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")
  
  val digits = Set(1, 7, 2, 9)
  digits contains 0 // false
  Set(1, 2) subsetOf digits // true
  
  val primes = Set(2, 3, 5, 7)
  println(digits union primes) // union 并集
  println(digits & primes) // intersect 交集
  println(digits -- primes) // 差集
}