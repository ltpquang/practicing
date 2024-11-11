package kotlin

/**
 * Created by Quang Le on 3/27/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 */

class SolutionMinPathSum {
  fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size

    val result = Array(m) { IntArray(n) }

    grid.forEachIndexed { i, ints ->
      ints.forEachIndexed { j, value ->
        when {
          i == 0 && j == 0 -> result[i][j] = value
          i == 0 -> result[i][j] = result[i][j - 1] + value
          j == 0 -> result[i][j] = result[i-1][j] + value
          else -> result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + value
        }
      }
    }

    return result[m-1][n-1]
  }
}
