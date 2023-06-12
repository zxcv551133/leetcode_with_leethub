class Solution {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
        fun getLowerBound(num: Int, lo: Int, hi: Int): Int {
            if(lo + 1 == hi) return lo
            val mi = (lo + hi) / 2
            return if(nums[mi] < num) {
                getLowerBound(num, mi, hi)
            } else {
                getLowerBound(num, lo, mi)
            }
        }

        val left = getLowerBound(target, - 1, nums.size)
        val right = getLowerBound(target + 1, - 1, nums.size)

        val size = right - left
        
        println("$right $left")

        return size > nums.size / 2
    }
}
