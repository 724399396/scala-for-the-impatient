package ch08Extends

object Test extends App {
  var alien = new Employee("Fred", "10.0") {
    def greeting = "Greetings, Earthling! My name is Fred."
  }
  
  def meet(p: Person{def greeting: String}) {
    println(p.name + " says:  " + p.greeting)
  }
  
  meet(alien)
  
  new LablePoint("Black Thursady", 1929, 230.07)
}