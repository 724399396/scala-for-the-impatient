package ch05Class


object Test {
  def main(args: Array[String]) {
    val chatter = new Network
    val myFace = new Network
    val fred = chatter.join("Fred")
    val wilma = chatter.join("Wilma")
    fred.contacts += wilma // OK
    val barney = myFace.join("Barney")
    fred.contacts += barney
    
    val s1 = new Student
    s1.getId();
  }
}