class Solution {
    fun canJump(nums: IntArray): Boolean {
        val visits = Array<Boolean>(nums.size) { false }
        visits[0] = true
        for (i in nums.indices) {
            if(!visits[i]) continue
            for (num in 1..minOf(nums.size - i - 1, nums[i])) {
                visits[num + i] = true
            }
        }
        return visits[nums.size - 1]
    }
}