package ch08Extends

class Employee(override val name:String, val salary:String) extends Person(name) {
  val id = name.hashCode() //no need override
  override def toString = super.toString() + "[salary= " + salary + "]"
}