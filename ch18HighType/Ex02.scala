package ch18HighType

class Bug2 {
  private var position = 0
  private var direction = 1
  def move(s:Int): this.type = {
    position += (direction * s)
    this
  }
  def turn(): this.type = {
    direction *= -1
    this
  }
  def show(): this.type = {
    println(position)
    this
  }
  def and(): this.type = this
  def then(): this.type = this
  def around(): this.type = this
}

object Ex02 {
  val bugsy = new Bug2
  //bugsy move 4 and show and then move 6 and show turn around move 5 and show
}
