package ch06Object

class Account private (val id: Int, initialBalance: Double) {
   var balance = initialBalance
  def deposit(amount: Double) { balance += amount }
}

object Account { //伴生对象
  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber += 1; lastNumber }
  def apply(initialBalance: Double) = 
    new Account(newUniqueNumber(), initialBalance)
}