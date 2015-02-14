package ch11Operator

class Money(val usd: Int, val cents: Int) {
  def +(other: Money) =
    if (this.cents + other.cents >= 100)
      new Money(this.usd + other.usd + 1, this.cents + other.cents - 100)
    else new Money(this.usd + other.usd, this.cents + other.cents)
  def -(other: Money) =
    if (this.cents < other.cents)
      new Money(this.usd - other.usd - 1, this.cents + 100 - other.cents)
    else new Money(this.usd - other.usd, this.cents - other.cents)
  def ==(other: Money) = 
    (this.usd == other.usd && this.cents == other.cents)
}

object Money {
  def apply(usd: Int, cents: Int): Money = new Money(usd, cents)
}

object Ex04 extends App {
 println(Money(1, 75) + Money(0, 50) == Money(2, 25))
}