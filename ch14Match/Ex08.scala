package ch14Match

object Ex08 extends App {
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(ch: Char, leafs: BinaryTree*) extends BinaryTree
  
  def eval(tree: BinaryTree): Int =
    tree match {
    case Leaf(v) => v
    case Node(op, l @ _*) => if (op == '+') l.map(eval).sum else if (op == '-') l.map(eval).reduceLeft(_ - _)
                                                      else l.map(eval).reduceLeft(_ * _)
  }
  
  val tree = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
  println(eval(tree))
}