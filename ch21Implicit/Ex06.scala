package ch21Implicit

import java.awt.Point

object Ex06 extends App {
  val p1 = new Point(1,2)
  val p2 = new Point(2,0)
  println(new DictionPoint(p1,p2).smaller)
}

class DictionPoint(val p1: Point, val p2: Point) {
  def smaller(implicit ord: Ordering[Int]): Point = {
    val x = ord.compare(p1.x, p2.x)
    if (x > 0) p2
    else if (x < 0) p1
    else {
      val y = ord.compare(p1.y, p2.y)
      if (y > 0) p2
      else if (y < 0) p1
    }
    p1
  }
}
