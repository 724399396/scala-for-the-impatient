package ch07Package


object ex06 extends App {
  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable._
  val javaMap: JavaHashMap[String,String] = new JavaHashMap()
  val scalaMap: HashMap[String,String] = HashMap()
  javaMap.put("Liwei", "Scala")
  for (k <- javaMap.keySet().toArray())
    scalaMap += (k.toString() -> javaMap.get(k))
}