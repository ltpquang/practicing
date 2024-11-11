package kt

/**
 * Created by Quang Le on 3/25/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor, and you can either start from
 * the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
class SolutionMinCostClimbingStairs {
  fun minCostClimbingStairs(cost: IntArray): Int {
    /**
     * f(i) = min(f(i - 1), f(i - 2)) + a(i)
     *
     */
//    val result = IntArray(cost.size)
//    result[0] = cost[0]
//    result[1] = cost[1]
//    for (i in 2..cost.size - 1) {
//      result[i] = Math.min(result[i - 2], result[i - 1]) + cost[i]
//    }
//    return Math.min(result[cost.size - 1], result[cost.size - 2])
    var minus2 = cost[0]
    var minus1 = cost[1]
    for (i in 2..cost.size - 1) {
      val currentMin = Math.min(minus1, minus2) + cost[i]
      minus2 = minus1
      minus1 = currentMin
    }
    return Math.min(minus1, minus2)
  }
}