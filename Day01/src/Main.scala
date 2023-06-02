import scala.io.Source

object Day01 extends App {
  private val filename = "/Users/john/IdeaProjects/AoC22Scala/Day01/input.txt"

  private def Part1(): Int = {
    var max = 0
    var currentTotal = 0
    for (line <- Source.fromFile(filename).getLines) {
      if (line.isBlank) {
        if (currentTotal > max) max = currentTotal
        currentTotal = 0
      } else {
        currentTotal += line.toInt
      }
    }
    max
  }

  println(Part1)

  private def Part2(): Int = {
    var totals: List[Int] = Nil
    var currentTotal = 0
    for (line <- Source.fromFile(filename).getLines) {
      if (line.isBlank) {
        totals = currentTotal :: totals
        currentTotal = 0
      } else {
        currentTotal += line.toInt
      }
    }

    totals.sorted(Ordering[Int].reverse).take(3).sum
  }

  println(Part2)

}