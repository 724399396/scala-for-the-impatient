package ch17TypeParameter


class Pair02[T](val first: T, val second: T) {
  def swap() = new Pair02(second, first)

  override def toString = first + ":" + second
}

object Ex02 extends App {
  val p = new Pair02("Li", 10)
  val np = p.swap()
  println(p)
  println(np)
}
