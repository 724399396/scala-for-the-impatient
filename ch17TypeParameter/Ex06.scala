package ch17TypeParameter


object Ex06 extends App {
  def middle[T <: Iterable[T]](i: T): T = {
    i.toBuffer(i.size/ 2)
  }
  //middle("String")
  //println(middle("World"))
}
