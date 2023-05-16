class Solution {
    fun minCostII(costs: Array<IntArray>): Int {
        val dp = Array(costs.size + 1) { IntArray(costs[0].size) }
        for (i in costs.indices) {
            for (j in costs[0].indices) {
                var minBefore = Int.MAX_VALUE
                for (k in costs[0].indices) {
                    if (k == j) continue
                    minBefore = kotlin.math.min(minBefore, dp[i][k])
                }
                dp[i + 1][j] = minBefore + costs[i][j]
            }
        }
        return dp[costs.size].min()!!
    }
}
