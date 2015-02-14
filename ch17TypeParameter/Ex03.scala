package ch17TypeParameter

class Pair03[T, S](val first: T, val second: S) {
  def swap(p: Pair03[T, S]) = {
    new Pair03(p.second, p.first)
  }

  override def toString = first + ":" + second
}

object Ex03 extends App {
  val p = new Pair03("Li", 10)
  val np = p.swap(p)
  println(p)
  println(np)
}
