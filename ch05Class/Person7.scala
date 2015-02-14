package ch05Class

class Person7(name: String) {
  val firstName: String = name.split(" ")(0)
  val lastName:String = name.split(" ")(1)
}