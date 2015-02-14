package ch05Class

import scala.collection.mutable.ArrayBuffer

object Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]
    }
}

class Network {

  private val member = new ArrayBuffer[Network.Member]
  
  def join(name: String) = {
    val m = new Network.Member(name)  
    member += m
    m
  }
}