import io.Source

object Loader extends App {
  val dataDirectory = "data/ch02/"
  val fileName = "rep_height_weights.csv"

  val file = Source.fromFile(dataDirectory + fileName)
  val lines = file.getLines.toVector
  val splitLines = lines.map { _.split(',') }

  splitLines.foreach { sline =>
//    println(s"sline: ${sline.getClass.getName}")
    val tmp = sline.mkString("[", ", ", "]")
//    val tmp = sline
    println(s"${tmp}")
  }
}
