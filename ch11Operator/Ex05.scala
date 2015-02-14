package ch11Operator

class Table {
  var str = ""
  def |(input: String): Table = {
    val t = Table()
    t.str = this.str + "<td>" + input + "</td>"
    t
  }

  def ||(input: String): Table = {
    val t = Table()
    t.str = this.str + "</tr><tr><td>" + input + "</td>"
    t
  }

  override def toString(): String = {
    "<table><tr>" + this.str + "</tr></table"
  }
}

object Table {
  def apply() = new Table()
}

object Ex05 extends App {
  println(Table() | "Java"| "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM,.NET" )
}