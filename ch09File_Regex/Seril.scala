package ch09File_Regex
  import scala.collection.mutable.ArrayBuffer
  
@SerialVersionUID(42L) class Person(val name: String) extends Serializable {
  private val friends = new ArrayBuffer[Person] // OK
}

object Seril extends App {
  val fred = new Person("fred")
  val liwei = new Person("liwei")
  val pes = new ArrayBuffer[Person]()
  pes += (fred, liwei)
  import java.io._
  val out = new ObjectOutputStream(new FileOutputStream("test.obj"))
  out.writeObject(pes)
  out.close
  val in = new ObjectInputStream(new FileInputStream("test.obj"))
  val savedFred = in.readObject().asInstanceOf[ArrayBuffer[Person]]
  println(pes.mkString)
  println(savedFred.mkString)
}