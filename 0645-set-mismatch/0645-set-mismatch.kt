class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val numCount = nums.groupBy { it }.mapValues { (_, value) -> value.size }
        val duplicate = numCount.filterValues { it > 1 }.keys.first()
        val lost = ((1..nums.size).toSet() - numCount.keys).first()
        return intArrayOf(duplicate, lost)
    }
}