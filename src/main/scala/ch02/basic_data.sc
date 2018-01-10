/**
Vector and Matrix
basic data type
*/

import breeze.linalg._


// cheat sheet: https://github.com/scalanlp/breeze/wiki/Linear-Algebra-Cheat-Sheet

val v = DenseVector(1.0, 2.0, 3.0)
val m = DenseMatrix((1.0, 2.0, 3.0), (4.0, 5.0, 6.0))

// element wise add, multiplication
v * 2.0
v + 2.0
m * 2.0

// add another Vector
v + DenseVector(4.0, 5.0, 6.0)

// dot product
v dot DenseVector(4.0, 5.0, 6.0) // = 32.0

// SparseVector for memory efficient
// HashVector balance between memory efficient and computation efficient


// build vector
DenseVector.ones[Double](5) // DenseVector(1.0, 1.0, 1.0, 1.0, 1.0)
DenseVector.zeros[Int](3) // DenseVector(0, 0, 0)


//linspace, equally spaced 5 values between 0.0 and 1.0
linspace(0.0, 1.0, 5) // DenseVector(0.0, 0.25, 0.5, 0.75, 1.0)

//tabulate
DenseVector.tabulate(4) { i => 2.0 * i + 0.5}

DenseMatrix.tabulate[Int](2,3) {
    (i, j) => i*2 + j
}
/* reult: DenseMatix[Int]
breeze.linalg.DenseMatrix[Int] =
0  1  2
2  3  4
*/

// construct from random
DenseVector.rand(3)
DenseMatrix.rand(2,3)

// from Array, Seq, List
DenseVector(Array(2,3,4))

val l = Seq(2,3,4)
DenseVector(l :_ *)

// vector index
val v = DenseVector.tabulate(5) { i => i.toDouble }
val v = DenseVector.tabulate(5) { _.toDouble }

v(-1) // last element
v(1 to 3) // a virutl view of v
v(v.size-1 to 0 by -1)

// slice
val vs = v(2,4) // a virtual view of v, not concrete
vs.toDenseVector // become concrete DVector

// IndexOutOfBounds
import scala.util.{Try, Success, Failure}
Try(v(4)) match {
    case Success(a) => println(s"$a, ${a.getClass}")
    case Failure(e) => println(s"$e")
}

// mask
val mask = DenseVector(true, false, false, true, true)
v
v(mask)

// filter
v( v <:< 3.0) // filter < 3.0


val m = DenseMatrix((1.0, 2.0, 3.0), (5.0, 6.0, 7.0))
m(1,2) // 7.0
m(1, -1) // 7.0
m(0 to 1, 1 to 2)

// select a column of matrix, yield a vector
m(::, 0)


// mutate vector
val v = DenseVector(1.0, 2.0, 3.0)

v(1) = 2.1 // v = (1.0, 2.1, 3.0)
assert(v == DenseVector(1.0,2.1,3.0))

v(0 to 1) := DenseVector(1.2, 2.2) // v = (1.2, 2.2, 3.0)
assert( v == DenseVector(1.2,2.2,3.0))

v(0 to 1) := 0.0 // v = (0.0,0.0,3.0)
assert( v == DenseVector(0.0,0.0,3.0))

// vector view
val v = DenseVector.tabulate(6) { _.toDouble }
assert( v == DenseVector(0.0, 1.0, 2.0, 3.0, 4.0, 5.0) )

val vEven = v( 0 to v.size-1 by 2)
assert( vEven == DenseVector(0.0, 2.0, 4.0))

// change vEven
vEven := 10.0
assert( vEven == DenseVector(10.0, 10.0, 10.0))
assert( v == DenseVector(10.0, 1.0, 10.0, 3.0, 10.0, 5.0))
