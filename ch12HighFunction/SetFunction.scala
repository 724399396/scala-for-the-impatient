package ch12HighFunction

import scala.math._

object SetFunction extends App {
  val num = 3.14
  val fun = ceil _  // 定义一个函数
  println(fun(num))
  println(Array(3.14, 1.42, 2.0).map(fun).mkString(","))
  val triple = (x: Double) => 3 * x // 也是函数
  
  println(Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x).mkString(","))
  
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25) //higher-order function
  println(valueAtOneQuarter(ceil _))
  println(valueAtOneQuarter(sqrt _))
  
  def mulBy(factor: Double) = (x: Double) => factor * x
  val quintuple = mulBy(5)
  println(quintuple(50))
  
  //val fun = 3 * _ // 错误：无法推断出类型
  val fun2 = 3 * (_: Double) // OK
  val fun3: (Double) => Double = 3 * _
}