package ch15Annotation

import scala.annotation._

object Base {
  @beans.BeanProperty var username = ""
  @volatile var done = false // 相当于Java的volatile变量
  @transient var recentLookups = new collection.immutable.HashMap[String, String] // 相当于Java的transient
  @strictfp def calculate(x: Double) = 1 //strict float point (精确浮点)
  @native def win32RegKeys(root: Int, path: String): Array[String] // native 本地方法
  
  /*@cloneable */ class Employee extends Cloneable
  @SerialVersionUID(6157032470129070425L)
  class Employee2 extends Serializable
}

class Book {
  @throws(classOf[java.io.IOException]) def read(filename: String) {}
}
