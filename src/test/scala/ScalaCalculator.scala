import com.kushan_scala.SampleCalculator
import org.scalatest.funsuite.AnyFunSuite

class ScalaCalculator extends AnyFunSuite{

  test("SampleCalculator Test") {
    assert(SampleCalculator.cube(3) === 27)
  }
}
