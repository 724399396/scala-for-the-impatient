package ch08Extends

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def deposit (amount: Double) = { balance += amount; balance }
  def withdraw (amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var balance = initialBalance
  override def deposit(amount: Double) = { balance += amount; balance -= 1; balance }
  override def withdraw(amount: Double) = { balance -= amount; balance -= 1; balance }
}

class SavingsAccount(initialBalance: Double) extends CheckingAccount(initialBalance) {
  private var balance = initialBalance
  private var free = 3
  override def deposit(amount: Double) = { balance += amount
      if (free > 0) { free -=1; balance } else { balance -= 1; balance }  
  }
  override def withdraw(amount: Double) = { balance -= amount 
     if (free > 0) { free -=1; balance } else { balance -= 1; balance }  
  }
  def earnMonthlyInterest {
    free = 3
  }
}