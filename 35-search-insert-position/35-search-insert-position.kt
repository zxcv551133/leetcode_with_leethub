class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return getLowerbound(nums, target)
    }

    private fun getLowerbound(nums: IntArray, target: Int): Int {
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
}