/**
 * Created by Quang Le on 4/17/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */

/**
 * Software Engineer test by Trello
 *
 * Write code to find a 5 letter string of characters that contains only letters from
 *
 * acdegilmnoprstuw
 *
 * such that the hash(the_string) is
 *
 * 491454843
 *
 * if hash is defined by the following pseudo-code:
 *
 * Int64 hash (String s) {
 *    Int64 h = 7
 *    String letters = "acdegilmnoprstuw"
 *    for(Int32 i = 0; i < s.length; i++) {
 *        h = (h * 37 + letters.indexOf(s[i]))
 *    }
 *    return h
 * }
 * For example, if we were trying to find the 7 letter string where hash(the_string) was 680131659347, the answer would be "leepadg".
 */
class TrelloTest {
  fun hash(s: String): Long {
    var h = 7.toLong()
    val letters = "acdegilmnoprstuw"
    for (i in 0..(s.length-1)) {
      h = (h * 37 + letters.indexOf(s[i]))
    }
    return h
  }

  fun dehash(h: Long): String {
    var input = h
    var result = ""
    val letters = "acdegilmnoprstuw"
    while (input != 7.toLong()) {
      val integral = input/37
      result += letters[(input - integral*37).toInt()]
      input = integral
    }
    println(result.reversed())
    return result.reversed()
  }
}