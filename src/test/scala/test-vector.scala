import breeze.linalg._
import org.scalatest._

class TestVector extends FlatSpec with Matchers {
    "A Int 2" should "be 2" in {
        val a = 2
        2 should be (2)
    }
}
