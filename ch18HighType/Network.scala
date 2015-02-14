package ch18HighType

import scala.collection.mutable.ArrayBuffer

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member] // 类型投影
  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object Test extends App {
  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred") // 类型为chatter.Member
  val barney = myFace.join("Barney") // 类型为myFace.Member
  fred.contacts += barney




}

class Book {
  import scala.collection.mutable._
  type Index = HashMap[String, (Int,Int)]
}