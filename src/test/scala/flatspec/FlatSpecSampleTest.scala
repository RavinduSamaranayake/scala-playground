package flatspec

import org.scalatest.flatspec.AnyFlatSpec

class FlatSpecSampleTest extends AnyFlatSpec{
  "An empty List" should "have size 0" in {
    assert(List.empty.isEmpty)
  }

  it should "throw an IndexOutOfBoundsException when trying to access any element" in {
    val emptyList = List();
    assertThrows[IndexOutOfBoundsException] {
      emptyList(1)
    }
  }
}
