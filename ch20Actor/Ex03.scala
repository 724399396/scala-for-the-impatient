package ch20Actor

import java.io.File

import scala.actors.Actor

object FileChooser extends Actor {
  var count = 0
  def act(): Unit = {
    while(true) {
      receive {
        case x: File => {
          x.listFiles().filter(_.isFile).filter(_.getName.endsWith("scala")).foreach{x =>
            count += 1
            val temp = new FileProcessor
            temp.start()
            link(temp)
            temp ! x
          }
          x.listFiles().filter(_.isDirectory).foreach(this ! _)
          if (x.listFiles().size == 1) { WordCounter ! (count, count); exit }
        }
      }
    }
  }
}

class FileProcessor extends Actor {
  val p = "l\\w+".r
  def act():Unit = {
    receive {
      case x : File => {
        val source = io.Source.fromFile(x).mkString
        //WordCounter ! p.findAllIn(source).size // Ex03
        for(word <- p.findAllIn(source))
          println(word)
      }
    }
  }
}

object WordCounter extends Actor {
  var count = 0
  var files = Int.MaxValue
  var receives = 0
  def act(): Unit = {
    while(true)
      receive {
        case x: Int => { count += x; receives += 1; if(files == receives) { println(count); exit}}
        case x: (Int, Int) => {files = x._1; this ! 0}
      }
  }
}

object Ex03 extends App {
  FileChooser.start()
  WordCounter.start()
  FileChooser ! new File("src")
}
