class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closest = Int.MAX_VALUE - 1000000
        for (first in nums.indices) {
            var second = first + 1
            var third = nums.size - 1
            while (second < third) {
                val currentSum = nums[first] + nums[second] + nums[third]
                if (kotlin.math.abs(target - closest) > kotlin.math.abs(target - currentSum)) {
                    closest = currentSum
                }
                if (currentSum > target) {
                    third--
                } else {
                    second++
                }
            }
        }
        return closest
    }
}