package ch12HighFunction

object Use extends App {
  (1 to 9).map(0.1 * _)
  
  (1 to 9).map("*" * _).foreach(println _)
  
  (1 to 9).filter(_ % 2 == 0) // 2 4 6 8
  
  (1 to 9).reduceLeft(_ * _) // 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9
  
  "Mary has a little lamb".split(" ").sortWith(_.length < _.length)
}