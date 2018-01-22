import io.Source

object Loader extends App {
  val DataDirectory = "data/ch02/"
  val fileName = "rep_height_weights.csv"

  val file = Source.fromFile(DataDirectory + fileName)

}
