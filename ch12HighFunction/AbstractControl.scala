package ch12HighFunction

object AbstractControl extends App {
  def runInThread(block: () => Unit) {
    new Thread() {
      override def run() { block() }
    }.start()
  }

  runInThread { () => println("Hi"); Thread.sleep(100); println("Bye") }

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  var x = 10
  until(x == 0) {
    x -= 1
    println(x)
  }

  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until (i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    return -1
  }
}