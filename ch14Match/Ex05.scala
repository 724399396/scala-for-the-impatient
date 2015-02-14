package ch14Match

object Ex05 extends App {
val l: List[Any] = List(List(3, 8), 2, List(5))

def leafSum(list: List[Any]): Int = {
  var total = 0
  list.foreach {
    lst =>
      lst match {
        case a: List[Any] => total += leafSum(a)
        case a: Int => total += a
      }
  }
  total
}

println(leafSum(l))
}