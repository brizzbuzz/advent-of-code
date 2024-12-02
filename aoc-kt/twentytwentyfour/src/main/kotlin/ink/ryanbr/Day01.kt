package ink.ryanbr

import kotlin.math.abs

object Day01 {

  fun silver(): Int {
    val input = getInput()

    val leftInput = input.filterIndexed { index, _ -> index % 2 != 0 }
    val rightInput = input.filterIndexed { index, _ -> index % 2 == 0 }

    val sortedLeftInput = leftInput.sorted()
    val sortedRightInput = rightInput.sorted()

    val delta = sortedLeftInput.zip(sortedRightInput) { l, r -> abs(r - l) }.sum()
    return delta
  }

  fun gold(): Int {
    val input = getInput()

    val leftInput = input.filterIndexed { index, _ -> index % 2 != 0 }
    val rightInput = input.filterIndexed { index, _ -> index % 2 == 0 }

    return leftInput.sumOf { l -> rightInput.count { r -> r == l } * l }
  }

  private fun getInput(): List<Int> = AdventUtils.readFile("day01.txt")
    .lines()
    .map { it.split(" ").filterNot { v -> v.isBlank() }.map { v -> v.toInt() } }
    .flatten()
}
