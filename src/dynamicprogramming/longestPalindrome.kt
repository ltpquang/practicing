package practicing

/**
 * Created by Quang Le on 3/26/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */

class SolutionLongestPalindrome {
  fun longestPalindrome(s: String): String {
    /**
     * State <i,j> is the answer (i: index, j: length) if
     * state <i+1, j-2> is palindrome && s[i] == s [i+j]
     *
     */
    if (s.length == 1) return s
    val data = Array(s.length + 1, { _ -> BooleanArray(s.length + 1, { len -> len == 0 }) })
    var result = s.substring(0, 1)

    println(String.format("%s - %d", s, s.length))
    //
    // length = 2
    // length = 3
    for (len in 1..s.length) { // [0, 1] -- 2~6
      for (i in 0 until s.length - len + 1) { // [0, 2) -- 0~6-2
        data[i][len] =
            len == 1
            || data[i + 1][len - 2] && s.get(i).equals(s.get(i + len - 1))
        println(String.format("%d - %d - %s -> %b", len, i, s.substring(i, i + len), data[i][len]))
        if (data[i][len] && len > result.length) {
          result = s.substring(i, i + len)
        }
      }
    }

    return result
  }
}