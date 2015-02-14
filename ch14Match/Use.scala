package ch14Match

import scala.collection.JavaConversions.propertiesAsScalaMap

object Use extends App {
  for ((k, v) <- System.getProperties)
    println(k + " -> " + v)

  //不匹配的悄悄失效
  for ((k, "") <- System.getProperties)
    println(k)
  for ((k, v) <- System.getProperties if v == "")
    println(k)
}