package ch14Match

object Base extends App {
  val ch: Char = 'a'
  var sign = 0
  var digit = 0
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case _ => sign = 0
  }

  //  val x  = 0
  //  val s = ""
  //  // 匹配类型
  // obj match {
  //    case x: Int => x
  //    case s: String => Integer.parseInt(s)
  //    case _: BigInt => Int.MaxValue
  //    case _ => 0
  //  }

  //数组
  val arr: Array[Int] = Array()
  arr match {
    case Array(0) => "0"
    case Array(x, y) => x + " " + y
    case Array(0, _*) => "0 ..."
    case _ => "something else"
  }

  // 列表
  val lst: List[Int] = List()
  lst match {
    case 0 :: Nil => "0"
    case x :: y :: Nil => x + " " + y
    case 0 :: tail => "0 ..."
    case _ => "Something else"
  }
  
  // 元组
  val pair:Tuple2[Int, Int] = (1,2)
  pair match {
    case (0, _) => "0 ..." 
    case (y, 0) => y + "0"
    case _ => "neither is 0"
  }
  
  //提取器
  val pattern = "([0-9]+) ([a-z]+)".r
  "99 bottles" match {
    case pattern(num, item) =>
  }
}