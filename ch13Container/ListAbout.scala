package ch13Container

object ListAbout extends App {
  val digits = List(4, 2)
  println(digits.tail.head)
  val list2 = 9 :: List(4, 2)
  println(list2)
  
  def sum(lst : List[Int]): Int = {
    if (lst == null) 0 else lst.head + sum(lst.tail)
  }
  
  def sum2(lst: List[Int]): Int = lst match {
    case Nil => 0
    case h :: t => h + sum(t)
  }
  
  val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)
  var cur = lst
  while (cur != Nil) {
    if (cur.elem < 0) cur.elem = 0
    cur = cur.next
  }
  println(lst)
  
  cur = lst
  while (cur != Nil && cur.next != Nil) {
    cur.next = cur.next.next
    cur = cur.next
  }
  println(lst)
}