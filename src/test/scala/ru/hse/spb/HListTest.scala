package ru.hse.spb
import org.junit
import ru.hse.spb.HList.HNil
import ru.hse.spb.Number.{Succ, Zero}

class HListTest {
  @junit.Test
  def testAppendable(): Unit = {
    assert(HListTest.list1.:::(HListTest.list2).equals(HListTest.list1AppendList2))
  }

  @junit.Test
  def testAppendableNil(): Unit = {
    assert(HListTest.list1.:::(HNil).equals(HListTest.list1))
    assert(HNil.:::(HListTest.list2).equals(HListTest.list2))
    assert(HNil.:::(HNil).equals(HNil))
  }

  @junit.Test
  def testZipable(): Unit = {
    assert(HListTest.list1.zip(HListTest.list2).equals(HListTest.list1ZipList2))
  }

  @junit.Test
  def testZipableDifferentLength(): Unit = {
    assert(HListTest.list1.zip(HListTest.list1AppendList2).equals(HListTest.list1ZipList2))
  }

  @junit.Test
  def testZipableNil(): Unit = {
    assert(HListTest.list1.zip(HNil).equals(HNil))
    assert(HNil.zip(HListTest.list2).equals(HNil))
    assert(HNil.zip(HNil).equals(HNil))
  }

  @junit.Test
  def testSplitable(): Unit = {
    assert(HListTest.list1AppendList2.splitAt(HListTest.THREE).equals(HListTest.list2, HListTest.list1))
    // HListTest.list1.splitAt(HListTest.FOUR)
  }

  @junit.Test
  def testSplitableZero(): Unit = {
    assert(HListTest.list1.splitAt(HListTest.ZERO).equals(HNil, HListTest.list1))
  }

  @junit.Test
  def testSplitableLast(): Unit = {
    assert(HListTest.list2.splitAt(HListTest.THREE).equals(HListTest.list2, HNil))
  }
}

object HListTest {
  private final val ZERO = Zero
  private final val ONE = Succ(ZERO)
  private final val TWO = Succ(ONE)
  private final val THREE = Succ(TWO)
  private final val FOUR = Succ(THREE)
  private final val list1 = HNil.::(12).::(3).::("word")
  private final val list2 = HNil.::("word2").::(17).::("word3")
  private final val list1AppendList2 = HNil.::(12).::(3).::("word")
    .::("word2").::(17).::("word3")
  private final val list1ZipList2 = HNil.::("word2", 12).::(17, 3).::("word3", "word")
}

