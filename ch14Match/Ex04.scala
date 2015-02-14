package ch14Match

object Ex04 extends App {
  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  case class Multiple(count: Int, items: Item) extends Item
  
  def price(it: Item): Double = it  match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    case Multiple(c, it) => price(it)   * c
  }
  
  val p = price(Multiple(10,Article("Blackwell Toster",29.95))) 
  println(p)
}