package ch06Object

import TrafficLightColor._

object Test extends App {
  def doWhat(color: TrafficLightColor) = {
    if (color == Red)  "stop"
    else if (color == Yellow) "hurry up"
    else "go"
  }
  
  for (c <- TrafficLightColor.values) println(c.id + ":" + c)
  
  TrafficLightColor(0)
  TrafficLightColor.withName("Red")
  
  for(p <- Poker.values) println(p)
  
}