package ch15Annotation

object Util extends App {
  def sum(xs: Seq[Int]): BigInt = {
    if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
  }

  // 自动对尾递归进行优化 或是用@tailrec标明
  def sum2(xs: Seq[Int], partial: BigInt): BigInt = {
    if (xs.isEmpty) partial else sum2(xs.tail, partial + xs.head)
  }

  sum2(1 to 1000000, 0)

  // 蹦床实现
  import scala.util.control.TailCalls._
  def evenLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(oddLength(xs.tail))
  def oddLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(evenLength(xs.tail))
  evenLength(1 to 1000000).result
  
  //跳转表生成与内联
  // @switch貌似换了
  //@inline //方法内联
  //@notinline //禁止内联
  
  //可省略的方法
  import scala.annotation._
  @elidable(500) def dump(props: Map[String, String]) {} 
  //如果使用 scalac -Xelide-below 800 **.scala
  
  //基本类型的特殊化
  def allDifferent[@specialized T] (x: T, y: T, z: T) = x != y && x != z && y != z
}