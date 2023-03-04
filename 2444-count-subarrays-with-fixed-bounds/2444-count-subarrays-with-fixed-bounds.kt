class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var minPos = -1
        var maxPos = -1
        var leftBound = -1
        var ret = 0L

        for (i in nums.indices) {
            if (nums[i] < minK || nums[i] > maxK) leftBound = i

            if (nums[i] == minK) minPos = i
            if (nums[i] == maxK) maxPos = i
            ret += kotlin.math.max(0, kotlin.math.min(maxPos, minPos) - leftBound)
        }

        return ret
    }
}
