class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        reverse(nums, 0, nums.size - k % nums.size - 1)
        reverse(nums, nums.size - k % nums.size, nums.size - 1)
        reverse(nums, 0, nums.size - 1)
    }

    fun reverse(nums: IntArray, st: Int, ed: Int): Unit {
        var lo = st
        var hi = ed
        while (lo < hi) {
            val temp = nums[lo]
            nums[lo] = nums[hi]
            nums[hi] = temp
            lo++
            hi--
        }
    }
}