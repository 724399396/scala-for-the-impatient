package ch08Extends

abstract class Shape {
  def centerPoint: Tuple2[Double, Double]
}

class Rectangle(x: Tuple2[Double, Double], y: Tuple2[Double, Double]) extends Shape {
  override def centerPoint: Tuple2[Double, Double] = {
    ((x._1 + y._1) / 2, (x._2 + y._2) / 2)
  }  
}

class Circle(a: Tuple2[Double, Double], r: Double) extends Shape {
  override def centerPoint: Tuple2[Double, Double] = {
    a
  }
}