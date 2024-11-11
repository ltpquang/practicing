package kotlin

/**
 * Created by Quang Le on 5/6/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class SolutionMaxSubArray {
  fun maxSubArray(nums: IntArray): Int {
    val size = nums.size
    var max_so_far = Integer.MIN_VALUE
    var max_ending_here = 0

    for (i in 0 until size) {
      max_ending_here += nums[i]
      if (max_so_far < max_ending_here)
        max_so_far = max_ending_here
      if (max_ending_here < 0)
        max_ending_here = 0
    }
    return max_so_far
  }
}