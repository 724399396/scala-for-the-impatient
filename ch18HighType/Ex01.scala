package ch18HighType

class Bug {
  private var position = 0
  private var direction = 1
  def move(s: Int) = {
    position += (s * direction)
    this
  }
  def turn() = {
    direction *= -1
    this
  }
  def show() = {
    println(position)
    this
  }
}

object Ex01 extends App {
 new Bug().move(4).show().move(6).show().turn().move(5).show()
}
