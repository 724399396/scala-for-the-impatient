package ch18HighType

trait Iterable[E, C[X] <: Container[X]] {
  def iterator(): Iterator[E]
  def build[F](): C[F]
  def map[F](f: (E) => F): C[F] = {
    val res = build[F]()
    val iter = iterator()
    while (iter.hasNext) res += f(iter.next())
    res
  }
}

trait Container[E] {
  def +=(e: E): Unit
}

//class Range(val low: Int, val high: Int) extends Iterable[Int, Buffer] {
//  def iterator() = new Iterator[Int] {
//    private var i = low
//    def hasNext = i <= high
//    def next() = { i += 1; i - 1 }
//  }
//
//  //def build[F]() = new Buffer[F]()
//}

class Buffer[E : Manifest] extends Iterable[E, Buffer] with Container[E] {
  private var capacity = 10
  private var length = 0
  private var elems = new Array[E](capacity)

  def iterator() = new Iterator[E] {
    private var i = 0
    def hasNext = i < length
    def next() = { i += 1; elems(i - 1)}
  }

  def +=(e: E): Unit = {
    if (length == capacity) {
      capacity = 2 * capacity
      val nelems = new Array[E](capacity)
      for (i <- 0 until length) nelems(i) = elems(i)
      elems = nelems
    }
    elems(length) = e
    length += 1
  }

  override def build[F](): Buffer[F] = null//new Buffer[F]
}

object HighType {

}
