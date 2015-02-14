package ch18HighType

import java.io.PrintWriter


trait Logger { def log(msg: String)}

class ConsoleLogger extends Logger {
  def log(msg: String): Unit = {
    println(msg)
  }
}

class FileLogger(path: String) extends Logger {
  val out = new PrintWriter(path)
  def log(msg: String): Unit = {
    out.println(msg)
  }
}

trait Auth {
  this: Logger =>
  def login(id: String, password: String): Boolean
}
//
//class MockAuth(path: String) extends Auth {
//  this: FileLogger =>
//  def login(id: String, password: String) = {
//    log(path)
//    true
//  }
//}

trait App2 {
  this: Logger with Auth =>
}

//object MyApp extends App with FileLogger("test.log") with MockAuth("users.txt")

trait LoggerComponent {
  trait Logger { def log(msg: String)}
  val logger: Logger
  class ConsoleLogger extends Logger {
    def log(msg: String): Unit = {
      println(msg)
    }
  }
  class FileLogger(path: String) extends Logger {
    val out = new PrintWriter(path)
    def log(msg: String): Unit = {
      out.println(msg)
    }
  }
}

trait AuthComponent {
  this: LoggerComponent => // 让我们可以访问日志器
  trait Auth {
    this: LoggerComponent#Logger =>
    def login(id: String, password: String): Boolean
  }
  val auth: Auth
  class MockAuth(path: String) extends Auth {
    this: LoggerComponent#Logger =>
    def login(id: String, password: String) = {
      log(path)
      true
    }
  }
}

object AppComponents extends LoggerComponent with AuthComponent {
  val logger = new FileLogger("text.log")
  val auth = null//new MockAuth("users.txt")
}

object DI {

}
