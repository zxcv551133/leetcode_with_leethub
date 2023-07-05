class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val leftAr = IntArray(nums.size + 2)
        val rightAr = IntArray(nums.size + 2)
        
        for(i in nums.indices) {
            if(nums[i] == 0) {
                leftAr[i + 1] = 0 
            } else {
                leftAr[i + 1] = leftAr[i] + 1
            }

            if(nums[nums.size - 1 - i] == 0) {
                rightAr[nums.size - i] = 0
            } else {
                rightAr[nums.size - i] = rightAr[nums.size - i + 1] + 1
            }
        }
        
        var ret = 0
        
        for(i in nums.indices) {
            val current = leftAr[i] + rightAr[i + 2]
            ret = kotlin.math.max(ret, current)
        }
        
        return ret
    }
}
