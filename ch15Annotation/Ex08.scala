package ch15Annotation

object Ex08 extends App {
//基本类型的特殊化
  def allDifferent[@specialized T] (x: T, y: T, z: T) = x != y && x != z && y != z
}