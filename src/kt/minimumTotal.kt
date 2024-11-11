package kt

/**
 * Created by Quang Le on 4/3/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

class SolutionMinimumTotal {
  fun minimumTotal(triangle: List<List<Int>>): Int {
    /**
     * The minimum total of path leading to position j in row i
     * f(i, j) =  when {
     *              j == 0 -> f(i-1, j) + a[i][j]
     *              j == a[i].size - 1 -> f(i-1, j-1) + a[i][j]
     *              else -> Min(f(i-1, j-1), f(i-1, j)) + a[i][j]
     *            }
     */
    if (triangle.isEmpty()) return 0

    val result = Array(triangle.size) { index -> IntArray(triangle[index].size) }

    for (i in 0 until triangle.size) {
      if (i == 0) {
        result[0][0] = triangle[0][0]
        continue
      }
      for (j in 0 until triangle[i].size) {
        result[i][j] = triangle[i][j] + when (j) {
          0 -> result[i - 1][j]
          triangle[i].size - 1 -> result[i - 1][j - 1]
          else -> Math.min(result[i - 1][j], result[i - 1][j - 1])
        }
      }
    }

    return result[triangle.size-1].min()!!
  }
}