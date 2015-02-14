package ch20Actor

import java.awt.image.BufferedImage
import java.io.File

import scala.actors.Actor

object Ex02 extends App {
  val image: BufferedImage = javax.imageio.ImageIO.read(new File("P40926-154014.jpg"))
  //image.setRGB(0,0,1000,1000,Array(1),1,1)
  //javax.imageio.ImageIO.write(image, "jpg", new File("1.jpg"))
}
