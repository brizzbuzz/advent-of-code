package ink.ryanbr

private typealias Level = Int
private typealias Report = List<Level>

object Day02 {
  fun silver(): Int {
    val input = getInput()
    return input.count { it.isSafe() }
  }

  fun gold(): Int {
    val input = getInput()
    return input.count { report ->
      report.isSafe() || report.indices.any { i ->
        report.removeAt(i).isSafe()
      }
    }
  }

  private fun getInput(): List<Report> = AdventUtils.readFile("day02.txt")
    .lines()
    .map { it.split(" ").filterNot { v -> v.isBlank() }.map { v -> v.toInt() } }

  private fun Report.isSafe(): Boolean =
    isNotEmpty() && hasSafeIncrements() && isUnidirectional()

  private fun Report.isUnidirectional(): Boolean =
    this == this.sorted() || this == this.sorted().reversed()

  private fun Report.hasSafeIncrements(): Boolean {
    if (size < 2) return true

    windowed(2).forEach { (a, b) ->
      val diff = kotlin.math.abs(a - b)
      if (diff < 1 || diff > 3) return false
    }
    return true
  }

  private fun List<Level>.removeAt(index: Int): Report =
    this.filterIndexed { i, _ -> i != index }
}
