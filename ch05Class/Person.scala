package ch05Class

class Person(val name: String, val age: Int) {
  var privateAge: Int = 0
  if (age < 0) privateAge = -age else privateAge = age
  println("Jus constructed another person")
  def description = name + " is " + privateAge + " years old"
}
