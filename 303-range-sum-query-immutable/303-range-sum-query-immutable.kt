class NumArray(private val nums: IntArray) {
    val preSum = nums.toList().fold(listOf(0)) { acc, num ->
        acc + (acc.last() + num)
    }.toIntArray()

    fun sumRange(left: Int, right: Int): Int {
        return preSum[right + 1] - preSum[left]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */