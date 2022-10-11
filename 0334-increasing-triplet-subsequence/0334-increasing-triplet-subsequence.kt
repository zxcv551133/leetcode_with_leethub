class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        val left = nums.fold(Pair(mutableListOf<Boolean>(), Int.MAX_VALUE)) { (acc, currentMin), value ->
            acc.add(currentMin < value)
            Pair(acc, kotlin.math.min(currentMin, value))
        }.first
        val right = nums.foldRight(Pair(mutableListOf<Boolean>(), Int.MIN_VALUE)) { value, (acc, currentMax) ->
            acc.add(currentMax > value)
            Pair(acc, kotlin.math.max(currentMax, value))
        }.first.reversed()

        val ret = left.zip(right).find { (min, max) -> min && max }
        return ret != null
    }
}