package ch05Class

import scala.beans.BeanProperty

class Student {
  @BeanProperty var name:String =""
  @BeanProperty var id:Long =10
}