class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        return nums.drop(1)
            .foldIndexed(listOf(Pair(0, nums[0]))) { idx, acc, numValue ->
                val firstCheckAcc = acc.dropWhile { it.first < idx + 1 - k }
                val currentMax = numValue + firstCheckAcc.first().second
                val dropAcc = firstCheckAcc.dropLastWhile { it.second <= currentMax }
                dropAcc + Pair(idx + 1, currentMax)
            }.last().second
    }
}