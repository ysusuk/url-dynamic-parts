import scala.util.Random

object Main extends App {

  def find(fst: String, snd: String): String = {
    fst.split("/").zip(snd.split("/")).zipWithIndex.map { el =>
      el match {
        case ((str1, str2), _) if str1 == str2 => str1
        case ((_, _), idx) => s"*query_${idx}_*"
      }
    }.mkString("/")
  }

  println(find("/users/Ben/info/location", "/users/Lewis/info/birthday"))
}
