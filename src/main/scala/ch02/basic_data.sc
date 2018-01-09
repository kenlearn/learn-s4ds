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

DenseVector.rand(3)

DenseMatrix.rand(2,3)
