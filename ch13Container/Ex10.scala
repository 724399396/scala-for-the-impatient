package ch13Container
import scala.collection.mutable.HashMap

object Ex10 extends App {
  val str = "abcabcabc"
  
  val count = str.par.aggregate(Map[Char, Int]())(
      (a,b) => a + (b -> (a.getOrElse(b, 0) + 1)) ,
   {(map1,map2) =>
     (map1.keySet ++ map2.keySet).foldLeft(Map[Char, Int]())(
         (a, b) => a + (b -> (map1.getOrElse(b, 0) + map2.getOrElse(b, 0))))} )
   
   println(count)
}