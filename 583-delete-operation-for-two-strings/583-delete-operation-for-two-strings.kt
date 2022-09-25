class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        
        word1.indices.forEach { idx1 ->
            word2.indices.forEach { idx2 ->
                dp[idx1 + 1][idx2 + 1] = if (word1[idx1] == word2[idx2]) {
                    dp[idx1][idx2] + 1
                } else {
                    kotlin.math.max(dp[idx1][idx2 + 1], dp[idx1 + 1][idx2])
                }
            }
        }
        val maxSub = dp[word1.length][word2.length]
        return word1.length - maxSub + word2.length - maxSub
    }
}