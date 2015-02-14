package ch20Actor

object ShareThread {
  import scala.actors.Actor._
  actor {
    react { // 偏函数f1
      case Withdraw(amount) => println(amount)
        react { // 偏函数f2
          case Deposit(amount) =>
            println("Deposit" + amount)
        }
    }
  }
  //第一次react调用将f1与actor的邮箱关联起来,退出，当Withdraw消息抵达，f1被调用.然后f1调用下一个react
  //f2与actor的邮箱关联起来，然后退出。当Deposit到达，f2被调用

  actor {
    def act(): Unit = {
      react {
        case Withdraw(amount) => {
          println("Withdrawing " + amount)
          act() // 再次调用保持act的循环
        }
      }
    }
  }
  actor {
    def act() {
      loop {
        react {
          case Withdraw(amount) => println(amount)
        }
      }
    }
  }
  // 带条件的loop
  actor {
    def act(): Unit = {
      loopWhile(true) {
        react {
          case Withdraw(amount) => println(amount)
        }
      }
    }
  }
}
