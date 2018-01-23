import breeze.linalg._
import breeze.stats._
import breeze.optimize._

object testOpt extends App {
  def f(xs:DenseVector[Double]) = sum(xs ^:^ 2.0)

  def compare(dv1:DenseVector[Double], dv2:DenseVector[Double]):DenseVector[Boolean] =
    (dv1 >:> dv2).toDenseVector

  def gradf(xs:DenseVector[Double]) = 2.0 *:* xs
  
}
