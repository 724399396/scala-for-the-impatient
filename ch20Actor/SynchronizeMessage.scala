package ch20Actor

// 同步消息, Future(和 Java 的 Future 很像)
object SynchronizeMessage extends App {
  val account = new AccountActor
  // !? 发送消息并等待回应 相应的接受要有 sender ! __ 或是 reply方法
  val reply = account !? Deposit(1000)
  reply match {
    case Balance(bal) => println("Current Balance:" + bal)
  }

  //带超时时间
//  import scala.actors.Actor._
//  actor {
//    worker ! Task(data, self)
//    receiveWithin(seconds * 1000) {
//      case Result(data) =>
//      case TIMEOUT => log
//    }
//  }
  val replyFuture = account !! Deposit(1000)
  val replyByFuture = replyFuture() // 调用将阻塞，直到返回
}
