package ru.hse.spb.ast

/* If we look at the sources of the Scala compiler, the only places where we
find Visitors are near the boundaries to the wider Java world. And that's
quite telling since compilers are the primary example that OOP adepts use to
justify the existence of the Visitor pattern.

Instead, in the Scala compiler, `Traverser`s and `Transformer`s are used. They
are alike Visitors, but better in some important ways:

 * No coupling between trees and the means of traversing them;
 * Less boilerplate due to not having only a single method that needs to be
    overridden;
 * If there are common operations that need to be done for all types of trees,
    in Visitor there is no easy way to perform them, while with Traversers one
    can anything within the `traverse` method;
 * Traversers can be more easily optimized to use less stack space by using
    queues instead of recursion;
 * One can match on trees by some arbitrary criterion, supplying the
    traversing code for many variants at the same time;
 * etc.
 */
class ExprTraverser {
  def traverse(expression: Expr): Unit = expression match {
    case Const(_) =>
    case BinOp(_, leftOperand, rightOperand) => {
      traverse(leftOperand)
      traverse(rightOperand)
    }
  }
}
