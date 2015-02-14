package ch15Annotation

object Ex05 {
  def read(path: String) = {
    scala.io.Source.fromFile(path).mkString
  }
}