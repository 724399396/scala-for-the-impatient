package ch14Match

object EnumLike extends App {
  sealed abstract class TrafficLightColor
  case object Red extends TrafficLightColor
  case object Yellow extends TrafficLightColor
  case object Green extends TrafficLightColor
  
  val color: TrafficLightColor = Red
  
  color match {
    case Red => "stop"
    case Yellow  => "hurry up"
    case Green => "go"
  }
}