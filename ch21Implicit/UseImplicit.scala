package ch21Implicit

object UseImplicit extends App {
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T])
    = if (a < b) a else b // 将调用order(a) < b,如果a没有<操作符的话
  smaller(40, 2)
  smaller("Hello", "World")
}

class Pair[T : Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]) =
    if (ord.compare(first, second) < 0) first else second
}

class Pair2[T : Ordering] (val first: T, val second: T) {
  def smaller =
  if(implicitly[Ordering[T]].compare(first, second) < 0) first else second
}

class Pair3[T : Ordering] (val first: T, val second: T) {
  def smaller = {
    import Ordered._
    if (first < second) first else second
  }
}
