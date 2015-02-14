package ch14Match

object Ex06 extends App {
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
  
  def sum(tree: BinaryTree): Int = 
    tree match {
      case Leaf(i) => i
      case Node(left, right)=> sum(left) + sum(right)
    }
}