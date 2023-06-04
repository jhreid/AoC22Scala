import scala.io.Source

object Day04 extends App {
  private val filename = "/Users/john/IdeaProjects/AoC22Scala/Day04/input.txt"

  private def part1(): Int = {
    val bufferedSource = Source.fromFile(filename)

    var count = 0
    for (line <- bufferedSource.getLines()) {
      val sections = line.split(',')
      val section1 = sections(0).split('-').map { c => c.toInt }
      val section2 = sections(1).split('-').map { c => c.toInt }

      if (isContained((section1(0), section1(1)), (section2(0), section2(1)))) count = count + 1
    }

    bufferedSource.close()
    count
  }

  println(part1())

  private def part2(): Int = {
    val bufferedSource = Source.fromFile(filename)

    var count = 0
    for (line <- bufferedSource.getLines()) {
      val sections = line.split(',')
      val section1 = sections(0).split('-').map { c => c.toInt }
      val section2 = sections(1).split('-').map { c => c.toInt }

      if (isOverlap((section1(0), section1(1)), (section2(0), section2(1)))) count = count + 1
    }

    bufferedSource.close()
    count
  }

  println(part2())

  private def isContained(section1: (Int, Int), section2: (Int, Int)): Boolean = {
    if (section1._1 <= section2._1 && section1._2 >= section2._2) return true
    if (section2._1 <= section1._1 && section2._2 >= section1._2) return true
    false
  }

  private def isOverlap(section1: (Int, Int), section2: (Int, Int)): Boolean = {
    if (section1._1 <= section2._1 && section1._2 >= section2._1) return true
    if (section2._1 <= section1._1 && section2._2 >= section1._1) return true
    false
  }
}
