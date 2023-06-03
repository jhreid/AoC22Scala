import scala.io.Source

object Day03 extends App {
  private val filename = "/Users/john/IdeaProjects/AoC22Scala/Day03/input.txt"

  private def part1(): Int = {
    val bufferedSource = Source.fromFile(filename)

    var score = 0
    val priorities = values()
    for (line <- bufferedSource.getLines()) {
      val c1 = line.slice(0, line.length / 2)
      val c2 = line.slice(line.length / 2, line.length)
      val common = c1.intersect(c2)
      score = score + priorities(common.charAt(0))
    }

    bufferedSource.close()

    score
  }

  println(part1())

  private def part2(): Int = {
    val bufferedSource = Source.fromFile(filename)

    var score = 0
    val priorities = values()
    val iter = bufferedSource.getLines()
    while (iter.hasNext) {
      val elf1 = iter.next()
      val elf2 = iter.next()
      val elf3 = iter.next()
      val common = elf1.intersect(elf2).intersect(elf3)
      score = score + priorities(common.charAt(0))
    }

    bufferedSource.close()

    score
  }

  println(part2())

  private def values(): Map[Char, Int] = {
    var score = 0
    def incScore(): Int = {
      score = score + 1
      score
    }
    val scores = ('a' to 'z')
      .map { c => c -> incScore }.toMap ++
      ('A' to 'Z')
        .map { c => c -> incScore }.toMap

    scores
  }
}