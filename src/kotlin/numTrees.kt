package kotlin

import kotlin.longestCommonPrefix.TreeNode

/**
 * Created by Quang Le on 3/30/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 */
/**
 * Definition for a binary tree node.
 */

class TreeNode(value: Int = 0) {
  val value = value
  var left: TreeNode? = null
  var right: TreeNode? = null
}

class SolutionNumTrees {
  fun numTrees(n: Int): Int {
    /**
     * State i: a(i) is the chosen to be the root node
     * f(i) = Number of tree for range [0, i-1] * Number of tree for range [i+1, n-1]
     *      = Number of tree for range [0, i-1] * Number of tree for range [0, n-i-2]
     *
     * num(n) = Number of tree can build with n integer
     *
     * num(n) =  sum(0 -> n) { num(i-1) * num(n-i-2) }
     *
     */

    // n - 2 - (n - 1)
    if (n == 0) return 1
    if (n == 1) return 1
    if (n == 2) return 2

    val treeCount = IntArray(n + 1)

    treeCount[0] = 1
    treeCount[1] = 1
    treeCount[2] = 2

    for (i in 3..n) {
      for (j in 0 until i) {
        treeCount[i] += treeCount[j] * treeCount[i - 1 - j]
      }
    }

    return treeCount[n]
  }

  class TreeNodeCreator {
    companion object {
      fun create(value: Int, left: TreeNode? = null, right: TreeNode? = null): TreeNode {
        val result = kotlin.longestCommonPrefix.TreeNode(value)
        result.left = left
        result.right = right
        return result
      }
    }
  }

  //region Tree wrapper
  val map = HashMap<String, List<TreeNode?>>()

  fun generateKey(start: Int, end: Int): String {
    return String.format("%d:%d", start, end)
  }

  fun getTrees(start: Int, end: Int): List<TreeNode?> {
    val key = generateKey(start, end)
    if (map[key] == null) {
      map[key] = buildTrees(start, end)
    }
    return map[key]!!
  }

  fun buildTrees(start: Int, end: Int): List<TreeNode?> {
    when {
      start > end -> return listOf(null)
      start == end -> return listOf(TreeNodeCreator.create(start))
      else -> {
        val result = ArrayList<TreeNode?>()
        //Tree of size n
        for (i in start..end) { //Iterate i
          val beforeTrees = getTrees(start, i - 1)
          val afterTrees = getTrees(i+1, end)

          when {
            beforeTrees.isEmpty() -> afterTrees.forEach { node -> result.add(TreeNodeCreator.create(i, null, node))}
            afterTrees.isEmpty() -> beforeTrees.forEach { node -> result.add(TreeNodeCreator.create(i, null, node))}
            else -> beforeTrees.forEach { beforeNode ->
              afterTrees.forEach { afterNode -> result.add(TreeNodeCreator.create(i, beforeNode, afterNode)) }
            }
          }
        }

        return result
      }
    }
  }
  //endregion

  fun generateTrees(n: Int): List<TreeNode?> {
    return getTrees(1, n).filterNotNull()
  }
}