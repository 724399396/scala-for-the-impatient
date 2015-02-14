package ch14Match

object Ex07 extends App {
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(leafs: BinaryTree*) extends BinaryTree

  def leafSum(tree: BinaryTree): Int =
    tree match {
      case Leaf(i) => i
      case Node(leafs @ _*) => leafs.map { x => leafSum(x) }.sum
    }
  
  val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  
  println(leafSum(tree))
}