package ch11Operator

class RichFile {
  val path = ""
  val name = ""
  val fileType = ""
}

object RichFile {
  def unapply(input: RichFile) = {
    Some((input.path, input.name, input.fileType))
  }
  
  def unapplySeq(input: RichFile): Option[Seq[String]] = {
    Some(input.toString().trim.split(""))
  }
}