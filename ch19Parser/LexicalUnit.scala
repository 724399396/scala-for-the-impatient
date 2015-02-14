package ch19Parser

import scala.util.parsing.combinator.syntactical.StandardTokenParsers

class MyLanguageParser extends StandardTokenParsers {
  lexical.reserved += ("auto", "break", "case", "char", "const")
  lexical.delimiters += ("=", "<", "<=", ">", ">=", "==", "!=")
}

class Expr3Parser extends StandardTokenParsers {
  lexical.delimiters += ("+", "-", "*" + "(" + ")")

  def expr: Parser[Any] = term ~ rep(("+" | "-") ~ term)
  def term: Parser[Any] = factor ~ rep("*" ~> factor)
  def factor: Parser[Any] = numericLit | "(" ~> expr <~ ")"

  def parseAll[T](p: Parser[T], in: String): ParseResult[T] =
    phrase(p)(new lexical.Scanner(in))
}

object LexicalUnit extends App {
  val expr = new Expr3Parser
  val result = expr.parseAll(expr.expr, "3-4-5")
  println(result.get)
}
