package kotlin

/**
 * Created by Quang Le on 3/27/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 */
class SolutionUniquePathsWithObstacles {
  fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid[0][0] == 1) return 0

    val m = obstacleGrid.size
    val n = obstacleGrid[0].size

    val result = Array(m) { IntArray(n) { 0 } }

    result.forEachIndexed { i, ints ->
      ints.forEachIndexed { j, _ ->
        when {
          obstacleGrid[i][j] == 1 -> {}
          i == 0 && j == 0 -> result[i][j] = 1
          i == 0 -> if (obstacleGrid[i][j-1] == 0 && result[i][j-1] != 0) result[i][j] = 1
          j == 0 -> if (obstacleGrid[i-1][j] == 0 && result[i-1][j] != 0) result[i][j] = 1
          else -> result[i][j] = result[i - 1][j] + result[i][j - 1]
        }
      }
    }

    return result[m-1][n-1]
  }
}