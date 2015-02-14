package ch08Extends

abstract class Person(val name: String) {
  val id: Int // abstract method
  override def toString = getClass.getName + "[name" + name + "]"
}