class Solution {
    fun minFlipsMonoIncr(s: String): Int {
        val preSum = s.fold(mutableListOf(0)) { acc, num ->
            acc.add(acc.last() + if (num == '1') 1 else 0)
            acc
        }.toIntArray()
        
        return (0..s.length).map { idx ->
            preSum[idx] + s.length - idx - preSum[s.length] + preSum[idx]
        }.min()!!
    }
}