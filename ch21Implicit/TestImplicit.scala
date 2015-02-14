package ch21Implicit

case class Delimiters(left: String, right: String)

object TestImplicit extends App {
  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right
  quote("Bonjour le monde")(Delimiters("<<", ">>"))
}

object FrenchPunctuation {
  implicit val quoteDelimiters = Delimiters("<<",">>")
}
