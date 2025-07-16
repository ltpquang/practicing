package kt.shortestSubarrayToBeRemoved

// 1574. Shortest Subarray to be Removed to Make Array Sorted
// Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
//
//Return the length of the shortest subarray to remove.
//
//A subarray is a contiguous subsequence of the array.
//
//Example 1:
//
//Input: arr = [1,2,3,10,4,2,3,5]
//Output: 3
//Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
//Another correct solution is to remove the subarray [3,10,4].
//
//Example 2:
//
//Input: arr = [5,4,3,2,1]
//Output: 4
//Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
//
//Example 3:
//
//Input: arr = [1,2,3]
//Output: 0
//Explanation: The array is already non-decreasing. We do not need to remove any elements.
//
class Solution1574(private var input: IntArray = IntArray(0), private var cache: MutableMap<String, Int> = mutableMapOf()) {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        input = arr
        if (input.notDecrease(0, input.size - 1)) {
            return 0
        }
        return findSubarraySize(-1, 0, input.size - 1, Int.MAX_VALUE)
    }

    private fun findSubarraySize(valueBefore: Int, i: Int, j: Int, valueAfter: Int): Int {
        val cacheKey = genKey(valueBefore, i, j, valueAfter)
        if (i > j) {
            cache[cacheKey] = 0
            return 0
        }
        var resultIfRemoveTheLeft = when (input[i] in valueBefore..valueAfter) {
            true -> findSubarraySize(input[i], i + 1, j, valueAfter)
            else -> j - i + 1
        }
        var resultIfRemoveTheRight = when (input[j] in valueBefore..valueAfter) {
            true -> findSubarraySize(valueBefore, i, j - 1, input[j])
            else -> j - i + 1
        }
        val result = if (resultIfRemoveTheLeft <= resultIfRemoveTheRight) {
            resultIfRemoveTheLeft
        } else {
            resultIfRemoveTheRight
        }
        cache[cacheKey] = result
        return result
    }

    private fun genKey(valueBefore: Int, i: Int, j: Int, valueAfter: Int): String {
       return "${valueBefore}_${i}_${j}_${valueAfter}"
    }

    private fun IntArray.notDecrease(fromIndex: Int, toIndex: Int): Boolean {
        for (i in fromIndex..<toIndex) {
            if (this[i] > this[i + 1]) {
                return false
            }
        }
        return true
    }
}