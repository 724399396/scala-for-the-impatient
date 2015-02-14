package ch07Package

package object random {
  var seed: Int = 0
  val a = BigDecimal(1664525)
  val b = BigDecimal(1013904223)
  val n = 32

  def nextInt(): Int = {
    val temp = (seed * 1664525 + 1013904223) % BigDecimal(2).pow(n)
    seed = temp.toInt
    seed
  }

  def nextDoubel(): Double = {
    val temp = (seed * 1664525 + 1013904223) % BigDecimal(2).pow(n)
    seed = temp.toInt
    temp.toDouble
  }
  
  def setSeed(seed: Int) {
    this.seed = seed;
  }
}

package random {
  object Random {

  }
}