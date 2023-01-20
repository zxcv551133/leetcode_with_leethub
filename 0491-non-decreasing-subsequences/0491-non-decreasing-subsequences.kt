class Solution {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val dp = Array(nums.size) { mutableListOf<List<Int>>() }
        val small = nums.mapIndexed { idx, num ->
            val mutableList = mutableListOf<Int>()
            for (i in 0 until idx) {
                if (nums[i] <= num) mutableList.add(i)
            }
            mutableList.toList()
        }
        for (i in nums.indices) {
            for (j in small[i]) {
                for (dpRet in dp[j]) {
                    val newList = dpRet + nums[i]
                    dp[i].add(newList)
                }
            }
            dp[i].add(listOf(nums[i]))
        }

        return dp.flatMap { it }.toSet().toList().filterNot { it.size == 1 }
    }
}