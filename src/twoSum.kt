import java.util.HashMap

/**
 * Created by Quang Le on 5/4/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val noteTakingMap = HashMap<Int, Int>()
    for ((i, value) in nums.withIndex()) {
      if (noteTakingMap.containsKey(value)) {
        return intArrayOf(noteTakingMap[value]!!, i)
      }
      noteTakingMap[target - value] = i
    }

    return intArrayOf()
  }
}