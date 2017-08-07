import scala.annotation.tailrec

object Main extends App {

  println(DynamicPartsNaive.find("/users/Ben/info/location", "/users/Lewis/info/birthday"))
  println(DynamicParts.find("/users/Ben/info/location", "/users/Lewis/info/birthday"))
}

trait DynamicParts {
  def find(path1: String, path2: String): String
}

object DynamicPartsNaive extends DynamicParts {
  val random = scala.util.Random

  def find(path1: String, path2: String): String = {
    path1.split("/").zip(path2.split("/")).zipWithIndex.map { el =>
      el match {
        case ((str1, str2), _) if str1 == str2 => str1
        case ((_, _), idx) => s"*query_${random.nextPrintableChar()}*"
      }
    }.mkString("/")
  }

}

// memory optimized
object DynamicParts extends DynamicParts {
  val random = scala.util.Random

  def find(path1: String, path2: String): String = {
    @tailrec
    def innerFind(path1: String, path2: String, accum: String): String = {
      if (path1.isEmpty)
        accum
      else {
        val (headFromPath1, tailFromPath1) = path1.span(_ != '/')
        val (headFromPath2, tailFromPath2) = path2.span(_ != '/')

        val path = (headFromPath1, headFromPath2) match {
          case (fromPath1, fromPath2) if fromPath1 == fromPath2 => fromPath1
          case (_, _) => s"*query_${random.nextPrintableChar()}*"
        }

        innerFind(tailFromPath1.drop(1), tailFromPath2.drop(1), accum ++ "/" ++ path)
      }
    }

    innerFind(path1.drop(1), path2.drop(1), "")
  }

}
