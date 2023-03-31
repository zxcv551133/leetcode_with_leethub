class Solution {
    fun maxA(n: Int): Int {
        val dp = IntArray( n + 1 + 10 )
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3
        dp[4] = 4
        dp[5] = 5
        for(i in 6..n) {
            var maxVal = dp[i]
            maxVal = kotlin.math.max(maxVal, dp[i - 3] * 2)
            maxVal = kotlin.math.max(maxVal, dp[i - 4] * 3)
            maxVal = kotlin.math.max(maxVal, dp[i - 5] * 4)
            dp[i] = maxVal
        }
        return dp[n]
    }
}
