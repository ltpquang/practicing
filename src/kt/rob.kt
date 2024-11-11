package kt

/**
 * Created by Quang Le on 3/23/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 */
class Solution3 {
  fun rob(nums: IntArray): Int {
    /**
     * Finding the subarray whose sum is max with no consecutive positions
     *
     * i is the state that f(i) is the sub array the meets the requirement
     *
     * 1 2 3 4 5 6 7 8 9 10
     *
     * f(i) = f(j) + a(i) | 4 > i - j > 1
     *
     * for each position i, we found the maximum cash of position i - 2
     */
//    var max = 0
//    val mem = IntArray(nums.size)
//    for ((index, value) in nums.withIndex()) {
//      if (index < 2) {
//        mem[index] = Math.max(max, value)
//      } else {
//        mem[index] = Math.max(max, mem[index - 2] + value)
//      }
//      max = mem[index]
//    }


    var previousMax = 0
    var currentMax = nums[0]
    for (i in 1 until nums.size) {
      val tmp = currentMax
      currentMax = Math.max(currentMax, previousMax + nums[i])
      previousMax = tmp
    }




    return currentMax
  }
}

class NumArray(nums: IntArray) {
  val nums = nums
  fun sumRange(i: Int, j: Int): Int {
    return nums.asList().subList(i, j + 1).sum()
  }
}
