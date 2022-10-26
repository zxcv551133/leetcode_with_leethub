class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        return nums.foldIndexed(Triple(mutableMapOf(Pair(0, -1)), 0, false))
        { idx, (roundMap, acc, result), currentNum ->
            val newAcc = (acc + currentNum) % k
            roundMap.putIfAbsent(newAcc, idx)
            val currentResult = roundMap[newAcc]!! < idx - 1
            Triple(roundMap, newAcc, result or currentResult)
        }.third
    }
}