package ch15Annotation

object Ex06 extends App {
  @volatile var flag: Boolean = false
  new Thread() {
    override def run() {
      while (!flag) {}
      println("find flag is true")
    }
  }.start()
  new Thread() {
    override def run() {
      Thread.sleep(1000);
      flag = true
      println("i have set")
    }
  }.start
}