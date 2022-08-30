class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var maxLen = 0
        for (num in numSet) {
            if (numSet.contains(num - 1)) {
                continue
            }
            var count = 1
            var numCopy = num + 1
            while (numSet.contains(numCopy++)) {
                count += 1
            }
            maxLen = kotlin.math.max(count, maxLen)
        }
        return maxLen
    }
}