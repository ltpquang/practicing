package kt

/**
 * Created by Quang Le on 3/23/18.
 *
 * "Whether you think you can, or you think you can't - you're right."
 * --Henry Ford--
 */
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 */
class SolutionMaxProfit {
  fun maxProfit(prices: IntArray): Int {
    //Find sub array that is [end - start] max
    /**
     * current_min_buy = current_max_sell = a[0]
     * foreach i
     *    if a[i] < current_min_buy
     *      current_min_buy = a[i]
     *      current_max_sell = a[i]
     *    if a[i] >= current_max_sell
     *      current_max_sell = a[i]
     */
    if (prices.isEmpty()) return 0

    var currentMax = 0
    var minBuy = prices[0]
    for (i in 1 until prices.size) {
      if (prices[i] < minBuy) {
        minBuy = prices[i]
      }

      currentMax = Math.max(currentMax, prices[i] - minBuy)
    }

    return currentMax
  }
}