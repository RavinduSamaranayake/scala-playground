import org.scalatest.funsuite.AnyFunSuite

class SampleTests extends AnyFunSuite{
  test("Accessing invalid index should throw IndexOutOfBoundsException") {
    val fruit = List("Banana", "Pineapple", "Apple");
    assert(fruit.head == "Banana")
    assertThrows[IndexOutOfBoundsException] {
      fruit(4)
    }
  }
}
