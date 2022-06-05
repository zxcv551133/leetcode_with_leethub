class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val numsRet = Array(nums.size) { 0 }
        var hi = nums.size - 1
        var lo = 0
        nums.indices.reversed().forEach { idx ->
            if (kotlin.math.abs(nums[lo]) > kotlin.math.abs(nums[hi])) {
                numsRet[idx] = nums[lo] * nums[lo]
                lo++
            } else {
                numsRet[idx] = nums[hi] * nums[hi]
                hi--
            }
        }
        
        return numsRet.toIntArray()
    }
}