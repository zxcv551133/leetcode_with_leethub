class Solution {
    fun getLowerbound(nums: IntArray, target: Int): Int {
        fun lowerbound(st: Int, ed: Int): Int {
            val mi = st / 2 + ed / 2 + (st % 2 + ed % 2) / 2
            return if (st + 1 >= ed) {
                ed
            } else if (nums[mi] >= target) {
                lowerbound(st, mi)
            } else {
                lowerbound(mi, ed)
            }
        }
        return lowerbound(-1, nums.size)
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val st = getLowerbound(nums, target)
        val ed = getLowerbound(nums, target + 1)
        val failArray = intArrayOf(-1, -1)
        return if (st == nums.size) {
            failArray
        } else if (nums[st] != target) {
            failArray
        } else {
            intArrayOf(st, ed - 1)
        }
    }
}