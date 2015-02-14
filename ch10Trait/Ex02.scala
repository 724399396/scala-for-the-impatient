package ch10Trait

import java.awt.Point

class OrderPoint extends Point with scala.math.Ordered[Point] {
  def compare(that: Point): Int = if (this.x <= that.x && this.y <= that.y) -1
                                                                else if (this.x == that.x && this.y == that.y) 0
                                                                else 1
}  

object Ex02 extends App {

}