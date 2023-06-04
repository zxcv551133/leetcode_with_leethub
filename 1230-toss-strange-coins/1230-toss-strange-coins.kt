class Solution {
    fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
        val dp = Array(prob.size + 1) {Array(prob.size + 1) {DoubleArray(2)} }

        dp[0][0][0] = 1.0
        
        for(j in 1..prob.size) {
            dp[0][j][0] = dp[0][j - 1][0] * (1 - prob[j - 1])
        }

        for (i in 1..prob.size) {
            for (j in 1..prob.size) {
                if(i > j) continue
                dp[i][j][0] = (dp[i][j - 1][0] + dp[i][j - 1][1]) * (1 - prob[j - 1])
                dp[i][j][1] = (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) * prob[j - 1]
            }
        }

        return dp[target][prob.size][0] + dp[target][prob.size][1]
    }
}
