package ch11Operator

class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  def sign(d: Int): Int = if (d >= 0) 1 else -1

  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def abs(a: Int): Int = if (a > 0) a else -a

  def +(other: Fraction): Fraction = {
    newFrac((this.num * other.den) + (other.num * this.den), this.den * other.den)
  }

  def -(other: Fraction): Fraction = {
    newFrac((this.num * other.den) - (other.num * this.den), this.den * other.den)
  }

  def *(other: Fraction): Fraction = {
    newFrac(this.num * other.num, this.den * other.den)
  }

  def /(other: Fraction): Fraction = {
    newFrac(this.num * other.den, this.den * other.num)
  }

  private def newFrac(a: Int, b: Int): Fraction = {
    val x: Int = if (b == 0) 1 else a * sign(b) / gcd(a, b);
    val y: Int = if (b == 0) 0 else b * sign(b) / gcd(a, b);
    new Fraction(x, y)
  }

  override def toString = num + "/" + den
}

object Fraction {

  def apply(n: Int, d: Int) = new Fraction(n, d)

  def unapply(input: Fraction) =
    if (input.den == 0) None else Some((input.num, input.den))
}