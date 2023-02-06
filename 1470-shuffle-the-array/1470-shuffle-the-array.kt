class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ret = mutableListOf<Int>()
        for (i in 0 until n) {
            ret.add(nums[i])
            ret.add(nums[n + i])
        }
        return ret.toIntArray()
    }
}