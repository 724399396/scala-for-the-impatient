package ch17TypeParameter

class Pair01[T, S](val first: T, val second: S) {
  def swap():Pair01[S, T] = {
    val newPair = new Pair01(this.second, this.first)
    newPair
  }

  override def toString = first + ":" + second
}

object Ex01 extends App {
  val p = new Pair01("Li", 10)
  val np = p.swap()
  println(p)
  println(np)
}
