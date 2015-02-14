package ch16Xml

import scala.xml._
import scala.xml.transform._

object MatchTransform extends App {
  val node: Node = <li></li>
  node match {
    case <img/> => 1 //没有后代
    case <li>{ _ }</li> => 2 //单个后代
    case <li>{ _* }</li> => 3 //任意后代
    case <li>{ child }</li> => child.text
    case <li>{ Text(item) }</li> => item
    case <li>{ children @ _* }</li> => for (c <- children) yield c
  }
  
  // copy 方法
  val list = <ul><li>Fred</li><li>Wilma</li></ul>
  val list2 = list.copy(label = "ol") //<ol><li>Fred</li><li>Wilma</li></ol>
  list.copy(child = list.child ++ <li>Another item</li>) //<ul><li>Fred</li><li>Wilma</li><li>Another item</li></ul>

  // % 修改
  val image = <image src="hamster.jpg"/>
  val image2 = image % Attribute(null, "alt", "An image of a hamster", Null)
  val image3 = image % Attribute(null, "alt", "An image of a frog",
    Attribute(null, "src", "frog.jpg", Null))
  println(image2)
  
  // XML 变换
  val rule1 = new RewriteRule {
    override def transform(n: Node) = n match {
      case e @ <ul>{_*}</ul > => e.asInstanceOf[Elem].copy(label = "ol")
      case _ => n
    }
  }
  val root: Node = <src></src>
  val transformed = new RuleTransformer(rule1).transform(root);
}