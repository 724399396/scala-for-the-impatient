package ch13Container

object Ex06 extends App {
  val lst = List(1, 2,3, 4, 5)
  val lst1 = (lst :\ List[Int]())(_ :: _)
  val lst2 = (List[Int]() /: lst)(_ :+ _)
  println(lst1)
  println(lst2)
  val lst3 = (lst:\ List[Int]())((a,b) => b :+ a)
  println(lst3)
}