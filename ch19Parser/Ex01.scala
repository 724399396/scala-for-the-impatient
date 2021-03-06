//package ch19Parser
//
//import scala.util.parsing.combinator.RegexParsers
//
//class ExprParser3 extends RegexParsers {
//  val number = "[0-9]+".r
//
//  def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
//    case t ~ None => t
//    case t ~ Some("+" ~ e) => t + e
//    case t ~ Some("-" ~ e) => t - e
//  }
//  //def term: Parser[Int] = factor ~ rep(opt("*" | "/" | "%") ~> factor) ^^ {
//    //case f ~ (e: List(Some("*" ~ ))) => f *
//  //}
//  def factor: Parser[Int] = number ^^ { _.toInt } |
//    "(" ~> expr <~ ")" //^^ { case _ ~ e ~ _ => e }
//}
//object Ex01 extends App {
//  val parser = new ExprParser
//  val result = parser.parseAll(parser.expr, "3-4*5")
//  if (result.successful) println(result.get)
//}
