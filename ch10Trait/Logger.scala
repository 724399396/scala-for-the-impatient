package ch10Trait

trait Logger {
  def log(msg: String) // abstract method
  def info(msg: String) { log("INFO: " + msg) }
  def warn(msg: String) { log("WARN: " + msg) }
  def severe(msg: String) { log("SEVERE: " + msg) }
}

trait ConsoleLogger extends Logger with Cloneable with Serializable { // use extends not implements
  def log(msg: String) { println(msg) } // no need override
}

trait SavingsAccount extends ch06Object.Account with Logger {
  def withdraw(amount: Double) {
    if (amount > balance) severe("Insufficient funs")
    else balance -= amount
  }

  override def log(msg: String) { println(msg) }
}

trait TimestampLogger extends Logger {
  abstract override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShorLogger extends Logger {
  val maxLength = 15
  abstract override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength) + "...")
  }
}
trait FileLogger extends Logger {
  val filename: String
  val out = new java.io.PrintWriter(filename) // part of constructor
  out.println("# " + new java.util.Date().toString()) // also part of constructor

  def log(msg: String) { out.println(msg); out.flush() }
}

trait LoggedException extends Logger {
  this: Exception =>
  def log() { log(getMessage()) }
}

abstract class UnhappyException extends Exception {  // 该类扩展自一个特质
  override def getMessage() = "arggh!"
}

object test extends App {

}