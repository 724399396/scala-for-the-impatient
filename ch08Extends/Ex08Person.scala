package ch08Extends

class Ex08Person(val name: String) {
  override def toString = getClass.getName + "[name" + name + "]"
}

class SecretAgent(codename: String) extends Ex08Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}