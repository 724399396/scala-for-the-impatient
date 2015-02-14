package ch20Actor

import scala.actors.Actor

class ComputeAverage extends Actor {
  def act() = {
    receive {
      case x: (Array[Int], Combiner) => { x._2 ! x._1.sum; exit() }
    }
  }
}

class Combiner extends Actor {
  var count = 0
  var total = 0
  def act() = {
    while(count < 8)
      receive {
        case x: Int => {
          total += x; count += 1
        }
      }
    println(total / 1000000)
    exit()
  }
}

object Ex01 extends App {
  val rand = new scala.util.Random
  val n = 1000000
  val combiner = new Combiner
  combiner.start()
  var a: Array[Int] = new Array[Int](n)
  a = a.map {x => rand.nextInt()}
  for(i <- a.grouped(n / 8)) {
    val compute = new ComputeAverage
    compute.start()
    compute ! (i,combiner)
  }

}
