package ch19Parser

//import scala.util.parsing.combinator.RegexParsers

class Expr
case class Number(value: Int) extends Expr
case class Operator(op: String, left: Expr, right: Expr) extends Expr

//class ExprParser2 extends RegexParsers {
//  def term: Parser[Expr] = (factor ~ opt("*" ~> term)) ^^ {
//    case a ~ None => a
//    case a ~ Some(b) => Operator("*", a, b)
//  }
//  def factor: Parser[Expr] = wholeNumber ^^ (n => Number(n.toInt)) |
//    "(" ~> expr <~ ")"
//  def expr: Parser[Int] = term ~ rep(
//    ("+" | "-") ~ term ^^ {
//      case "+" ~ t => t
//      case "-" ~ t => -t
//    }) ^^ { case t ~ r => t + r.sum}
//  )
//}

class ParserTree {

}

object Test2 {
  //Operator("+", Number(3), Operator("*", Number(4), Number(5)))
}
