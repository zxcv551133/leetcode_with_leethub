class Solution {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        nums1.indices.forEach { idx1 ->
            nums2.indices.forEach { idx2 ->
                dp[idx1 + 1][idx2 + 1] =
                    if (nums1[idx1] == nums2[idx2]) {
                        dp[idx1][idx2] + 1
                    } else 0
            }
        }
        return dp.map { it.max()!! }.max()!!
    }
}