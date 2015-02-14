package ch16Xml
import scala.xml._

object Base extends App {
  // scala.xml.Elem
  val doc = <html><head><title>Fred's Memoirs</title></head><body></body></html>
  //scala.xml.NodeSeq
  val items = <li>Fred</li><li>Wilma</li>;
  val elem = <a href="http://scala-lang.org">The <em>Scala</em> languagu</a>
  //使用NodeBuffer构建Xml
  val items2 = new NodeBuffer
  items2 += <li>Fred</li>
  items2 += <li>Wilma</li>
  val nodes: NodeSeq = items2
  // 元素属性
  val url = elem.attributes("href")
  val image = <img alt="San Jose State University Logo" src="http://www.sjsu.edu/publicaffairs/pic/sjsu_logo_color_web.jpg"/>
  val alt = image.attributes("alt")

  val image2 = <img alt="TODO	" src="hamster.jpg"/>
  val map = image2.attributes.asAttrMap // Map("alt" -> "TODO", "src" -> "hamster.jpg")

  // 内嵌表达式
  <ul><li>{ items(0) }</li><li>{ items(1) }</li></ul>
  <ul>{ for (i <- items) yield <li>{ i }</li> }</ul>
  <hl>The Natural mubers{{1, 2, 3, ...}}</hl> // <hl>The Natural number{1, 2, 3, ...}</hl>

  // 属性中使用表达式
  val description = ""
  //<img src={makeUrl(fileName)} />
  <img alt={ if (description == "TODO") null else description }/>

  //特殊节点类型
  val code = """if (temp < 0) alter("Cold!")"""
  val js = <script>{ PCData(code) }</script>

  //  val n1 = <xml:unparsed><&></xml:unparsed>
  val n2 = Unparsed("<&>")

  val g1 = <xml:group><li>Item 1</li><li>Item 2</li></xml:group>
  val g2 = Group(Seq(<li>Item 1</li>, <li> Item 2</li>))

  //XPath
  val list = <dl><dt>Java</dt><dd>Gosling</dd><dt>Scala</dt><dd>Odersky</dd></dl>
  val languages = list \ "dt" // 匹配<dt></dt>
  doc \\ "img" // 匹配所有img元素
  image  \ "@alt" //@开头可定位属性
  doc \\ "@alt" // 定位任何元素的alt属性
  
  (<img src="hamster.jpg"/><img src="frog.jpg"/> \\ "@src").text //hamster.jpgfrog.jpg
}