package ch20Actor

import scala.actors.{Channel, OutputChannel, Actor}
import scala.actors.Actor._

case class Compute(input: Seq[Int], result: OutputChannel[Int])
class Computer extends Actor {
  def act(): Unit = {
    while (true) {
      receive {
        case Compute(input, out) => {val answer = input.sum; out ! answer}
      }
    }
  }
}

object MesChannel extends App {
  val channel = new Channel[Int]
  val computeActor: Computer = new Computer
  val input: Seq[Int] = Array(1,2,5,8)
  computeActor ! Compute(input, channel)
  channel.receive {
    case x => println(x) // 已知x是一个Int
  }
}
