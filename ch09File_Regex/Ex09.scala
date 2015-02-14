package ch09File_Regex

import java.io.File

object Ex09 extends App {

def subdirs(dir:File):Iterator[File]={
  val children = dir.listFiles().filter(_.getName.endsWith("scala"))
  children.toIterator ++ dir.listFiles().filter(_.isDirectory).toIterator.flatMap(subdirs _)
}
 
  val n =  subdirs(new File("//home//liwei//ScalaWorkspace")).length

println(n)
}