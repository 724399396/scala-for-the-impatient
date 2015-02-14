package greeter

class Counter {
  private var value = 0 
  def increment() { 
    if (value == Int.MaxValue)
      println("Count is already use out")
    else 
      value += 1
  } 
  def isLess(other: Counter) = value < other.value
}