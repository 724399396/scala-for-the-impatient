package ch08Extends

abstract class Ex04Item {
  def price: Double
  def description: String
}

class SimpleItem(p: Double, d: String) extends Ex04Item {
  override val price = p
  override val description = d
}

class Bundle {
  val items: Array[Item] = Array()
  def price = {
    var temp: Double = 0
    for (i <- items) temp += i.price
    temp
  }
}