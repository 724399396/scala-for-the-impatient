package ch18HighType

trait Reader {
  type Contents
  def read(fileName: String): Contents
}

class StringReader extends Reader {
  type Contents = String
  def read(fileName: String) = scala.io.Source.fromFile(fileName, "UTF-8").mkString
}

class ImageReader extends Reader {
  type Contents = java.awt.image.BufferedImage
  def read(fileName: String) = javax.imageio.ImageIO.read(new java.io.File(fileName))
}

object AbstractType {

}
