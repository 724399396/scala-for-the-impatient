package ch20Actor

import scala.actors.Actor
import scala.actors.Actor._

class HiActor extends Actor {
  def act(): Unit = {
    while (true) {
      receive {
        case "Hi" => println("Hello")
      }
    }
  }
}

object HiActorTest extends App {
  // 通过继承Actor 并start
  val actor1 = new HiActor
  actor1.start()

  // 通过伴生对象来创建
  val actor2 = actor {
    while(true) {
      receive {
        case "Hi" => println("Hello")
      }
    }
  }

  // 通过!发送消息
  actor1 ! "Hi"

  case class Charge(creditCardNumber: Long, mechant: String, amount: Double)
  val fraudControl = actor {
    while(true) {
      receive {
        case Charge(ccnum, merchant, amt) => println(ccnum)
      }
    }
  }
  fraudControl !  Charge(4111111111111111L, "Fred's Bait And Tackle", 19.95)
}

// 接受消息，“邮箱”是串行化的，不会竞争
class AccountActor extends Actor {
  private var balance = 0.0

  def act(): Unit = {
    while(true) {
      receive {
        case Deposit(amount) => { balance += amount; sender ! Balance(balance) }
        case Withdraw(amount) => { balance -= amount; sender ! Balance(balance) }
      }
    }
  }
}

case class Deposit(val amount: Double)
case class Withdraw(val amount: Double)
class Balance(val balance: Double)
object Balance {
  def unapply(x: Any): Option[Any] = Some(x)

  def apply(b: Double): Balance = new Balance(b)
}