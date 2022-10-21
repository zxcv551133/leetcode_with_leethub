class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val mutableSet = mutableSetOf<Int>()
        nums.indices.forEach { idx ->
            val shouldBeSize = minOf(idx + 1, k + 1)
            mutableSet.add(nums[idx])
            if (shouldBeSize > mutableSet.size) {
                return true
            }
            if (idx - k >= 0) {
                mutableSet.remove(nums[idx - k])
            }
        }
        return false
    }
}