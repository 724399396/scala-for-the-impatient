package ch13Container
import scala.collection.mutable._

object Operations extends App {
  println(Vector(1, 2, 3) :+ 5) // 不可变集合 原集合不变
  println(1 +: Vector(1, 2, 3))

  val numbers = ArrayBuffer(1, 2, 3)
  numbers += 5 // 将5添加到numbers

  var numbers2 = Set(1, 2, 3)
  numbers2 += 5 // 返回一个新的不可变集
  var numberVector = Vector(1, 2, 3)
  numberVector :+= 5

  Set(1, 2, 3) - 2

  // 便捷方法
  val names = List("Peter", "Paul", "Mary")
  names.map(_.toUpperCase) // List("PETER", "PAUL", "MARY")
  // for (n <- names) yield n.toUpperCase
  // flatMap 传入的函数产生集合
  def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())
  names.map(ulcase) //List(Vector(PETER, peter), Vector(PAUL, paul), Vector(MARY, mary))
  names.flatMap(ulcase) // List(PETER, peter, PAUL, paul, MARY, mary)

  "-3+4".collect { case '+' => 1; case '-' => -1 } //Vector(-1, 1)

  //reduceLeft foldLeft
  val freq = scala.collection.mutable.Map[Char, Int]()
  for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
  (Map[Char, Int]() /: "Mississippi") {
    (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
  }
  //包含中间结果的scan
  (1 to 10).scanLeft(0)(_ + _)

  // 拉链操作
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  prices zip quantities //List((5.0,10), (20.0,2), (9.95,1))
  (prices zip quantities) map { p => p._1 * p._2 } //List(50.0, 40.0, 9.95)
  
  List(5.0, 20.0, 9.95) zip List(10, 2) // List((5.0, 10), (20.0, 2)) 以短的为主
  // zipAll可以指定缺省
  List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1) //List((5.0,10), (20.0,2), (9.95,1))
  // zipWithIndex可得到下标
  "Scala".zipWithIndex //Vector((S,0), (c,1), (a,2), (l,3), (a,4))
}