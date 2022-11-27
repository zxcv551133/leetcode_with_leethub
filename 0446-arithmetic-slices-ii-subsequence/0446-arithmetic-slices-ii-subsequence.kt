class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val mutableMap = mutableMapOf<Int, MutableMap<Long, Int>>()
        var ans = 0
        for (i in nums.indices) {
            mutableMap[i] = mutableMapOf()
            for (j in 0 until i) {
                val diff = nums[i].toLong() - nums[j].toLong()
                val jValue = mutableMap[j]!![diff]
                val currentValue = mutableMap[i]!!.getOrDefault(key = diff, defaultValue = 0)
                if (jValue == null) {
                    mutableMap[i]!![diff] = currentValue + 1
                } else {
                    ans += jValue
                    mutableMap[i]!![diff] = currentValue + jValue + 1
                }
            }
        }
        return ans
    }
}