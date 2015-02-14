package ch10Trait

trait Logger2 {
  def log(str: String, key: Int = 3): String
}

class CryptoLogger extends Logger2 {
  def log(str: String, key: Int): String = {
    for (i <- str) yield if (key >= 0) (97 + ((i - 97 + key) % 26)).toChar 
    else (97 + ((i - 97 + 26 + key)% 26)).toChar
  }
}

object Ex04 extends App {
      val cl = new CryptoLogger
      println(cl.log("Li Wei"))
      println(cl.log("Liwei", -3))
}