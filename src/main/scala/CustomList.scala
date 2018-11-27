sealed abstract class CustomList[+A] {
  def listToString: String
}

object Nil extends CustomList[Nothing] {
  override def listToString: String = ""
}

case class Cons[A](value: A, tail: CustomList[A]) extends CustomList[A] {
  override def listToString: String = value.toString + " " + tail.listToString

}

