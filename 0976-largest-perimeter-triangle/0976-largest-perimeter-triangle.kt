class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sort()
        for (i in nums.size downTo 3) {
            val (a, b, c) = Triple(nums[i - 1], nums[i - 2], nums[i - 3])
            if (a < b + c) {
                return a + b + c
            }
        }
        return 0
    }
}