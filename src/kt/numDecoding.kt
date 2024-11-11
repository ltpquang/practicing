package kt

/**
 * Created by Quang Le on 3/28/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 * 262 -> 2|6|2 - 26|2
 * 212 -> 2|1|2 - 21|2 - 2|12
 * 210 -> 2|1|0 - 2|10
 *
 */

class SolutionNumDecodings {
  fun numDecodings(s: String): Int {
    if (s.isEmpty() || !isValid(s, 0, 1)) return 0
    if (s.length == 1) return isValid(s).toInt()
    if (s.length == 2) {
      return if (Integer.parseInt(s.substring(0, 1)) == 0) {
        0
      } else {
        isValid(s).toInt() + isValid(s, 1, 2).toInt()
      }
    }

    val result = IntArray(s.length)
    result[0] = 1
    result[1] = isValid(s,1,2).toInt() + isValid(s, 0, 2).toInt()

    for (i in 2 until s.length) {
      if (!isValid(s, i, i + 1) && !isValid(s, i - 1, i + 1)) {
        return 0
      }
      if (isValid(s, i, i + 1)) {
        result[i] += result[i - 1]
      }
      if (isValid(s, i - 1, i + 1)) {
        result[i] += result[i - 2]
      }
    }
    return result[s.length - 1]
  }

  fun isValid(input: String, startIndex: Int = 0, endIndex: Int = input.length): Boolean {
    if (Integer.parseInt(input.substring(startIndex, startIndex + 1)) == 0) return false
    return Integer.parseInt(input.substring(startIndex, endIndex)) in 1..26
  }

  fun Boolean.toInt(): Int {
    return if (this) 1 else 0
  }
}