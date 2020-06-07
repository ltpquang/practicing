package practicing

/**
 * Created by Quang Le on 3/23/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

class SolutionClimbStairs {
  fun climbStairs(n: Int): Int {
    // How many way to combine 1s and 2s to make n
    // F[i] is the number of way to make i from 1 and 2
    // F[i] = F[i-1] + F[i-2]
    // F[1] = 1
    // F[2] = 2
    // F[3] = F[2] + F[1] = 3
    // F[4] = F[3] + F[2] = 5 (1111 - 121 - 112 - 211 - 22)
    if (n < 3) return n

    val result = IntArray(n + 1)
    result[0] = 0
    result[1] = 1
    result[2] = 2
    for (i in 3..n) {
      result[i] = result[i - 1] + result[i - 2]
    }
    return result[n]
  }
}