package ch16Xml

import java.io.{ FileInputStream, InputStreamReader }
import java.net.URL

object LoadAndSave extends App {
  import scala.xml.XML
  val root = XML.loadFile("myfile.xml")
  val root2 = XML.load(new FileInputStream("myfile.xml"))
  val root3 = XML.load(new InputStreamReader(
    new FileInputStream("myfile.xml"), "UTF-8"))
  val root4 = XML.load(new URL("http://"))

  // 需要DTD
  import scala.xml.parsing.ConstructingParser
  import java.io.File
  val parser = ConstructingParser.fromFile(new File("myfile.xml"), preserveWS = true)
  val doc = parser.document
  val root5 = doc.docElem

  //读取XHTML
  import scala.xml.parsing._
  import scala.xml.dtd._
  val hParser = new XhtmlParser(scala.io.Source.fromFile("myfile.html"))
  val hDoc = hParser.initialize.document
  hParser.ent ++= List(
    "nbsp" -> ParsedEntityDecl("nbsp", IntDef("\u00A0")),
    "eacute" -> ParsedEntityDecl("eacute", IntDef("\u00E9")))

  // 保存xml
  XML.save("myfile.xml", root)
  // 写入XHTML
 XML.save("myfile.xhtml", root,
     enc = "UTF-8",
     xmlDecl = true,
     doctype = DocType("html",
         PublicID("-//W3C//DTD XHTML 1.0 Strict//EN",
             "http://www.w3.org//TR//xhtml1//DTD//xhtml1-strict.dtd"),
             Nil))
}

// 自结束标签
//val str = root.Utility.toXML(node, minitizeTags = true)