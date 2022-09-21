class Solution {
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
        val currentEvenSum = nums.filter { it % 2 == 0 }.sum()
        return queries.fold(Pair(mutableListOf<Int>(), currentEvenSum)) { (acc, evenSum), q ->
            val addition = q[0]
            val idx = q[1]
            val qNum = nums[idx]
            val nextEvenSum = when (Pair((addition % 2 + 2) % 2, (qNum % 2 + 2) % 2)) {
                Pair(0, 0) -> evenSum + addition
                Pair(0, 1) -> evenSum
                Pair(1, 0) -> evenSum - qNum
                Pair(1, 1) -> evenSum + qNum + addition
                else -> null
            }
            nums[idx] = nums[idx] + addition
            acc.add(nextEvenSum!!)
            Pair(acc, nextEvenSum)
        }.first.toIntArray()
    }
}