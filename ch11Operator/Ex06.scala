package ch11Operator

class ASCIIArt (val f1: String, val f2: String, val f3: String, val f4: String, val f5: String) {
  def concact(other: ASCIIArt): ASCIIArt = {
    val maxLength = Array(f1+other.f1 ,f2+other.f2, f3+other.f3, f4+other.f4, f5+other.f5).maxBy { i => i.length() }.length
    val a = new ASCIIArt(produce(f1, other.f1, maxLength), produce(f2, other.f2, maxLength),
        produce(f3, other.f3, maxLength), produce(f4, other.f4, maxLength), produce(f5, other.f5, maxLength))
    a
  }
  def produce(str1: String, str2: String, max: Int): String = {
    str1 + " " *  (max + 1 - str1.length - str2.length())+ str2
  }
  override def toString = f1 + "\r\n" + f2 + "\r\n" + f3 + "\r\n" + f4 + "\r\n" + f5
}

object Ex06 extends App {
  println(new ASCIIArt("""/\_/\""", """( ' ' )""", """(  -  )""", """ | | |""", """(__|__)""") concact
      new ASCIIArt("""-----""", """|  / Hello \""", """ <  Scala |""", """\ Coder /""", """-----"""))
}