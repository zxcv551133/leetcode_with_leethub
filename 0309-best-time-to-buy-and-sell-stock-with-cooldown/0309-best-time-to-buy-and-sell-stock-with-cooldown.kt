class Solution {
    fun maxProfit(prices: IntArray): Int {
        val hold = Array(prices.size) { 0 }
        val sell = Array(prices.size) { 0 }
        val rest = Array(prices.size) { 0 }
        hold[0] = -prices[0]
        for (i in 1 until prices.size) {
            hold[i] = maxOf(rest[i - 1] - prices[i], hold[i - 1])
            sell[i] = hold[i - 1] + prices[i]
            rest[i] = maxOf(sell[i - 1], rest[i - 1])
        }
        return maxOf(rest[prices.size - 1], sell[prices.size - 1])
    }
}