package ch06Object

object Poker extends Enumeration {
  val Spade = Value("♠")
  val Heart = Value("♥")
  val Club = Value("♣")
   val  Diamond = Value("♦")
   
}

class Poker {
   def checkRed(card: Poker.Value):Boolean =  {
      if (card.id == 1 || card.id == 3) true
      else false
    }
}