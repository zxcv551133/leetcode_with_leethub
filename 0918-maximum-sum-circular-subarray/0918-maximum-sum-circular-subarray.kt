class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var currentMax = Int.MIN_VALUE
        var sofarMax = Int.MIN_VALUE
        var currentMin = Int.MAX_VALUE
        var sofarMin = Int.MAX_VALUE
        for (num in nums) {
            sofarMax = maxOf(sofarMax, 0) + num
            currentMax = maxOf(sofarMax, currentMax)
            sofarMin = minOf(sofarMin, 0) + num
            currentMin = minOf(currentMin, sofarMin)
        }
        val sumValues = nums.sum()
        return if (nums.all { it < 0 }) {
            nums.max()!!
        } else {
            maxOf(currentMax, sumValues - currentMin)
        }
    }
}