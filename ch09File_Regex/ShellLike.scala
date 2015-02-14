package ch09File_Regex

object ShellLike extends App {
  import scala.sys.process._
  "ls -al .." !
  
  val result = "ls -al .." !!
  
  // pipe
  "ls -al .." #| "grep sec" !
  
  // out reset dest
  "ls -al .." #> new java.io.File ("output.txt")  !
  
  // append
  "ls -al .." #>> new java.io.File("output.txt") !
  
  // as in
  "grep sec" #< new java.io.File("output.txt") !
  
  "grep Scala" #< new java.net.URL("http://horstmann.com/index.html")
  
  //val p = Process(cmd, new File(dirName), ("LANG", "en_US"))
}