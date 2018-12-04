import org.junit.Assert.assertEquals
import org.junit.{Before, Test}
import ru.hse.spb.BST

class BSTTest {
  private var intBST: BST[Int] = _
  private var stringBST: BST[String] = _

  @Before
  def setup(): Unit = {
    intBST = new BST[Int]()
    stringBST = new BST[String]()
  }

  @Test
  def emptyBstSizeTest(): Unit = {
    assertEquals(0, intBST.getSize)
  }

  @Test
  def emptyBstContainsTest(): Unit = {
    assertEquals(false, intBST.contains(1))
  }

  @Test
  def emptyBstToArrayTest(): Unit = {
    assertEquals(0, intBST.toArray.length)
  }

  @Test
  def addOneElementContainsTest(): Unit = {
    stringBST.add("jbronergmfw")
    assertEquals(true, stringBST.contains("jbronergmfw"))
  }

  @Test
  def deleteFromEmptyBstTest(): Unit = {
    intBST.delete(10)
    assertEquals(false, intBST.contains(10))
  }

  @Test
  def addAndDeleteTest(): Unit = {
    stringBST.add("gmpeKGOP40!!!!!")
    assertEquals(1, stringBST.getSize)
    assertEquals(true, stringBST.contains("gmpeKGOP40!!!!!"))
    stringBST.delete("gmpeKGOP40!!!!!")
    assertEquals(0, stringBST.getSize)
    assertEquals(false, stringBST.contains("gmpeKGOP40!!!!!"))
  }

  @Test
  def doubleAddTest(): Unit = {
    intBST.add(231241231)
    intBST.add(231241231)
    assertEquals(1, intBST.getSize)
    intBST.delete(231241231)
    assertEquals(0, intBST.getSize)
  }

  @Test
  def testManyElementsStringToArray(): Unit = {
    stringBST.add("de")
    stringBST.add("asd")
    stringBST.add("greg")
    stringBST.add("abcde")
    stringBST.add("32")
    stringBST.add("fewf")
    stringBST.add("fewf324")
    stringBST.add("fewf324e32")
    stringBST.add("fewf324e3223")
    assertEquals("32 abcde asd de fewf fewf324 fewf324e32 fewf324e3223 greg", stringBST.toArray.mkString(" "))
  }

  @Test
  def iteratorTest(): Unit = {
    stringBST.add("d")
    stringBST.add("a")
    stringBST.add("b")
    stringBST.add("c")
    stringBST.add("32")
    stringBST.add("fewf")
    stringBST.add("fewf324")
    stringBST.add("fewf324e32")
    stringBST.add("fewf324e3223")
    val it = stringBST.iterator
    assertEquals("32", it.next)
    assertEquals("a", it.next)
    assertEquals("b", it.next)
    assertEquals("c", it.next)
    assertEquals("d", it.next)
    assertEquals("fewf", it.next)
    assertEquals("fewf324", it.next)
    assertEquals("fewf324e32", it.next)
    assertEquals("fewf324e3223", it.next)
    assertEquals(false, it.hasNext)
  }

  @Test
  def foreachSumTest(): Unit = {
    var sum = 0
    intBST.add(1)
    intBST.add(32)
    intBST.add(3)
    intBST.add(99)
    intBST.foreach(i => sum += i * i)
    assertEquals(10835, sum)
  }

  @Test
  def mapStrTest(): Unit = {
    intBST.add(1)
    intBST.add(32)
    intBST.add(3)
    intBST.add(99)
    val newBst = intBST.map(i => i.toString)
    assertEquals("1 3 32 99", newBst.toArray.mkString(" "))
  }

  @Test
  def flatMapTest(): Unit = {
    intBST.add(1)
    intBST.add(-31)
    intBST.add(3)
    intBST.add(10)
    val newBst = intBST.flatMap(i => BST(1 to i: _*))
    assertEquals("1 2 3 4 5 6 7 8 9 10", newBst.toArray.mkString(" "))
  }

  @Test
  def loopTest(): Unit = {
    var s = ""
    stringBST.add("ca")
    stringBST.add("wq")
    stringBST.add("ONE")
    stringBST.add("HSE")
    stringBST.add("wefw")
    for (data <- stringBST) s += data
    assertEquals("HSEONEcawefwwq", s)
  }
}
