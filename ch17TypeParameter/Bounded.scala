package ch17TypeParameter

// <: 和 Java 的 extends 一致
class Pair2[T <: Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
}

// >:下界
class Pair3[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Pair3[R](newFirst, second)
}

//<% 视图界定 意为可隐式转换
class Pair4[T <% Comparable[T]](var first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
}

// Ordered排序
class Pair5[T <% Ordered[T]](val first: T, val second: T) {
  def smaller = if (first < second) first else second
}

//上下文界定(隐式转换)
class Pair6[T: Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]) =
    if (ord.compare(first, second) <0) first else second
}

//类型约束
class Pair7[T] (val first: T, val second: T) (implicit ev: T <:< Comparable[T])

object Bounded extends App {
  val p = new Pair2("Fred", "Brooks")
  println(p.smaller)
  val p2 = new Pair4(4, 2)
  
  // Manifest上下文界定
  def makePair[T: Manifest] (first: T, second: T) {
    val r = new Array[T](2); r(0) = first; r(1) = second
  }
  
  //类型界定
  def firstLast[A, C] (it: C) (implicit ev: C <:< Iterable[A]) =
    (it.head, it.tail)
  firstLast(List(1, 2, 3))
} 