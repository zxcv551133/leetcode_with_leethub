class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = -1
        var currentSum = 0
        var ret = Int.MAX_VALUE
        for (i in nums.indices) {
            val currentVal = nums[i]
            currentSum += currentVal
            while (currentSum >= target && left < i) {
                ret = kotlin.math.min(ret, i - left)
                left++
                currentSum -= nums[left]
            }
        }

        return if (ret == Int.MAX_VALUE) 0 else ret
    }
}
