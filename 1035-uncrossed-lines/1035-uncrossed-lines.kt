class Solution {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        for (i in 1..nums1.size) {
            for (j in 1..nums2.size) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                }
                val prev = kotlin.math.max(dp[i - 1][j], dp[i][j - 1])
                dp[i][j] = kotlin.math.max(dp[i][j], prev)
            }
        }
        
        return dp[nums1.size][nums2.size]
    }
}
