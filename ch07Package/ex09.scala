package ch07Package

object ex09 extends App {
  import java.lang.System._
  val name = getProperty("user.name")
  val secrect = Console.readLine()
  if (secrect == "secret")
    out.println("Hello, " + name)
  else
    err.println("error passwd")
}