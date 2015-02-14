package ch13Container

object Ex03 extends App {
  def  removeZero(lst: Seq[Int]) = {
    lst.filterNot { x => x == 0 }
  }
  
  println(removeZero(Array(2,0,11,5,7,6,0,1,2)))
}