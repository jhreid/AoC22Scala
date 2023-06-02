import scala.io.Source
import scala.util.Using

object Day02 extends App {
  private val filename = "/Users/john/IdeaProjects/AoC22Scala/Day02/input.txt"

  private def part1(): Int = {
    val bufferedSource = Source.fromFile(filename)
    val scores = Map(
      "A X" -> 4,
      "A Y" -> 8,
      "A Z" -> 3,
      "B X" -> 1,
      "B Y" -> 5,
      "B Z" -> 9,
      "C X" -> 7,
      "C Y" -> 2,
      "C Z" -> 6
    )

    var score = 0
    for (line <- bufferedSource.getLines()) {
      score += scores(line)
    }

    bufferedSource.close()

    score
  }

  println(part1())

  private def part2(): Int = {
    val bufferedSource = Source.fromFile(filename)
    val scores = Map(
      "A X" -> 3, // lose 0 + 3
      "A Y" -> 4, // draw 3 + 1
      "A Z" -> 8, // win 6 + 2
      "B X" -> 1, // lose 0 + 1
      "B Y" -> 5, // draw 3 + 2
      "B Z" -> 9, // win 6 + 3
      "C X" -> 2, // lose 0 + 2
      "C Y" -> 6, // draw 3 + 3
      "C Z" -> 7 // win 6 + 1
    )

    var score = 0
    for (line <- bufferedSource.getLines()) {
      score += scores(line)
    }

    bufferedSource.close()

    score
  }

  println(part2())

}