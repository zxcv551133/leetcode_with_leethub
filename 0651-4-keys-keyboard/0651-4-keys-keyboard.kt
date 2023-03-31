class Solution {
    fun maxA(n: Int): Int {
        val dp = IntArray( n + 8 + 10 )
        dp[8] = 1
        dp[9] = 2
        dp[10] = 3
        dp[11] = 4
        dp[12] = 5
        for(i in 12..n + 7) {
            var maxVal = dp[i]
            maxVal = kotlin.math.max(maxVal, dp[i - 3] * 2)
            maxVal = kotlin.math.max(maxVal, dp[i - 4] * 3)
            maxVal = kotlin.math.max(maxVal, dp[i - 5] * 4)
            maxVal = kotlin.math.max(maxVal, dp[i - 6] * 5)
            maxVal = kotlin.math.max(maxVal, dp[i - 7] * 6)
            maxVal = kotlin.math.max(maxVal, dp[i - 8] * 7)
            dp[i] = maxVal
            println(dp[i])
        }
        return dp[n + 7]
    }
}
