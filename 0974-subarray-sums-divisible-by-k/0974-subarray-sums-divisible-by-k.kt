class Solution {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val preSum = nums.fold(mutableListOf(0)) { list, current ->
            list.add(((list.last() + current) % k + k) % k)
            list
        }.toList()
        val divisorMap = mutableMapOf<Int, Int>()
        var ret = 0
        for (current in preSum) {
            val divisor = divisorMap.getOrElse(current) { 0 }
            ret += divisor
            divisorMap[current] = divisor + 1
        }

        return ret
    }
}