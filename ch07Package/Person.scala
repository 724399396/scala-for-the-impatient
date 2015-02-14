package ch07Package
package com.horstmann.impatient

package object people {
  val defualtName = "Jogn Q. Public"
}

package people {
  class Person {
    val name = defualtName
    private[impatient] def description = "A person with name " + name
  }
}