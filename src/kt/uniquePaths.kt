package kt

/**
 * Created by Quang Le on 3/27/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
class SolutionUniquePaths {
  fun uniquePaths(m: Int, n: Int): Int {
    if (m == 1 || n == 1) {
      return 1
    }
    val result = Array(m) { _ -> IntArray(n) }

    result.forEachIndexed { i, ints ->
      ints.forEachIndexed { j, _ ->
        when {
          i == 0 && j == 0 -> result[i][j] = 0
          i == 0 || j == 0 -> result[i][j] = 1
          else ->   result[i][j] = result[i - 1][j] + result[i][j - 1]
        }
      }
    }

    return result[m-1][n-1]
  }
}