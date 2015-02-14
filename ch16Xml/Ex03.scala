package ch16Xml

import scala.xml._

object Ex03 extends App {
  println(<li>Fred</li> match { case <li>{Text(t)}</li> => t})
  println(<li>{"Fred"}</li> match { case <li>{Text(t)}</li> => t})
}