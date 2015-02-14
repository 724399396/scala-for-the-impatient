package ch05Class

class Timer2(hours: Int, minutes: Int) {
  val recordByMinute = hours * 60 + minutes;
  
  def befor(other: Timer2): Boolean = {
    return recordByMinute < other.recordByMinute;
  }
}