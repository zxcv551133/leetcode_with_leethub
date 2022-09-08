class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        return nums.drop(1)
            .foldIndexed(mutableListOf(Pair(0, nums[0]))) { idx, acc, numValue ->
                if (acc.first().first < idx + 1 - k) acc.removeAt(0)
                val currentMax = numValue + acc.first().second
                while (acc.isNotEmpty() && acc.last().second <= currentMax) {
                    acc.removeAt(acc.size - 1)
                }
                acc.add(Pair(idx + 1, currentMax))
                acc
            }.last().second
    }
}