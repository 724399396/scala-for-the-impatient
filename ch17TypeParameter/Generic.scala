package ch17TypeParameter

class Pair[T, S](val first: T, val second: S)

object Generic extends App {
  val p = new Pair(42, "String") // Pair[Int, String]
  val p2 = new Pair[Any, Any](42, "String")
  
  def getMiddle[T] (a: Array[T]) = a(a.length / 2)
  getMiddle(Array("Mary", "had", "a", "little", "lamb")) // 推断为getMiddle[String]
  val f = getMiddle[String] _ //指定的String型的方法
  
}