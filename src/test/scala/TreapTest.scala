import org.scalatest._

class TreapTest extends FlatSpec with Matchers {
  "An empty treap" should "be created successfully" in {
    val treap = new Treap()
    treap.size() should be (0)
  }
}