package ch10Trait

import java.awt.Point
import java.beans.PropertyChangeSupport

trait PropertyChange extends PropertyChangeSupport {

}

object Ex05 extends App {
  //val p = new Point() with PropertyChange
}