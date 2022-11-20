class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var left = true
        var right = true
        for (i in 1 until nums.size) {
            if (nums[i] < nums[i - 1]) {
                left = false
            }
            if (nums[i] > nums[i - 1]) {
                right = false
            }
        }
        return left || right
    }
}