package ch10Trait

class IterableInputStream extends java.io.InputStream with Iterable[Byte] {
  def read():Int = 0
  
  def iterator: Iterator[Byte] = null
}

object Ex10 {

}