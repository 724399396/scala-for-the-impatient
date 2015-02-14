package ch18HighType

import java.awt.Rectangle


object Type {
  // 结构类型 通过反射来调用 比java interface灵活 类似动态语言的鸭子类型
//  def appendLines(target: {def append(str: String): Any},
//                   lines: Iterable[String, Buffer]): Unit = {
//    for (l <- lines) { target.append(l); target.append("\n") }
//  }

  // 复合类型
  import scala.collection.mutable.ArrayBuffer
  val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]
  val rect = new Rectangle(5, 10, 20, 30)
  image += rect
  //import java.awt.geom.Area
  //image += new Area(rect) // 错误, 不是 Serializable

  // 存在类型 forSome
  def process[M <: n.Member forSome {val n: Network}] (m1: M, m2: M) = (m1,m2)
  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred")
  val wilma = chatter.join("Wilma")
  val barney = myFace.join("Barney")
  process(fred, wilma) // OK
  //process(fred, barney) // 错误

  // 自身类型

}
