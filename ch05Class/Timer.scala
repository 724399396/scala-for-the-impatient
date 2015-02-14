package ch05Class

class Timer(val hours: Int, val minutes: Int) {
  def befor(other: Timer) = {
    if(hours > other.hours) true
    else if (hours < other.hours) false
    else if (minutes > other.minutes) true
    else if (minutes <= other.minutes) false
  }
}