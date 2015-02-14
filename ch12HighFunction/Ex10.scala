package ch12HighFunction

object Ex10 extends App {
  def unless(condition: => Boolean) (ope: => Unit) {
    if(!condition) ope
    else ()
  }
  
  unless(false) (println("1"))
}