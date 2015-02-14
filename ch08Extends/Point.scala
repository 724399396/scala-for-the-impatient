package ch08Extends

class Point(val x: Double, val y: Double) {

}

class LablePoint(val describle: String, override val x: Double, override val y: Double)
            extends Point(x, y) {
  
}