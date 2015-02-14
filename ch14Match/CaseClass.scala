package ch14Match

object CaseClass extends App {
  abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  case object Nothing extends Amount

  val amt: Amount = Currency(29.95, "EUR")
  amt match {
    case Dollar(v) => "$" + v
    case Currency(_, u) => "Oh noes, I got " + u
    case Nothing => ""
  }

  abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  val nest = Bundle("Father's day special", 20.0,
    Article("Scala for the Impatent", 39.95),
    Bundle("Anchor Distillery Sampler", 10,
      Article("Old potrero Straight Rye Whisky", 79.95),
      Article("Junipero Gin", 32.95)))
  nest match {
    case Bundle(_, _, Article(descr, _), _*) => println(descr)
    case Bundle(_, _, art @ Article(_, _), rest @ _*) => { println(art); println(rest) }
    case Bundle(_, _, art @ Article(_, _), rest) => { println(art); println(rest) }
  }
  
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
  }
}