package ch17TypeParameter

class Person extends Friend[Person]
class Student extends Person
class Pair8[+T](val first: T, val second: T)

trait Friend[-T] {
  def befriend(someone: T) {}
}

object TypeChange extends App {
  def makeFriend(p: Pair8[Person]) {}
  makeFriend(new Pair8[Person](new Person(), new Person()))
  makeFriend(new Pair8[Student](new Student(), new Student()))

  def makeFriendWith(s: Student, f: Friend[Student]) { f.befriend(s) }

  val susan = new Student
  val fred = new Person
  makeFriendWith(susan, fred)

  def friends(students: Array[Student], find: Student => Person) =
    for (s <- students) yield find(s)
}