package ch11Operator

object ApplyAndUpdate extends App {
  val scores = new scala.collection.mutable.HashMap[String, Int]
  scores("Bob") = 100 //调用scroes.update("Bob", 100)
  val bobsScore = scores("Bob") // 调用scores.apply("Bob")
  
  val result = Fraction(3, 4) * Fraction(2, 5)
  println(result)
  
  val author = "Cay Horstmann"
  val Name(first, last) = author // 调用Name.unapply(author)
  
  val Number(n) = "1729"
  println(n)
}

object Name {
   def unapply(input: String) = {
     val pos = input.indexOf(" ")
     if (pos == -1) None
     else Some((input.substring(0, pos), input.substring(pos +1 )))
   } 
   
     def unapplySeq(input: String): Option[Seq[String]] = 
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
}

object Number {
  def unapply(input: String): Option[Int] = 
    try{
      Some(Integer.parseInt(input.trim))
    } catch {
      case es: NumberFormatException => None
    }
}

object IsCompound {
  def unapply(input: String) = input.contains(" ")
}