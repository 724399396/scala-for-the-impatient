package ch13Container

object StreamAbout extends App {
def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
val tenOrMore = numsFrom(10)
println(tenOrMore)
println(tenOrMore.tail.tail.tail)

val squares = numsFrom(1).map(x => x * x)
println(squares)
println(squares.take(5).force)

// 懒视图
import scala.math.pow
val powers = (0 until 1000).view.map(pow(10, _))
println(powers(100))
(0 to 1000).map(pow(10, _)).map(1 / _)
(0 to 1000).view.map(pow(10, _)).map(1 / _).force

// 并行
for (i <- (0 until 10).par) print(i + " ") // 并行随机的 
for (i <- (0 until 10).par) yield i + " " // 0 1 2 3 4 5 6 7 8 9
}