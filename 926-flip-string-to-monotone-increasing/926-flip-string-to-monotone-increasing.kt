class Solution {
    fun minFlipsMonoIncr(s: String): Int {
        val preSum = s.fold(mutableListOf(0)) { acc, num ->
            acc.add(acc.last() + if (num == '1') 1 else 0)
            acc
        }.toIntArray()
        
        return (0..s.length).map { idx ->
//            preSum[idx] 란 0부터 idx - 1 까지의 1의 개수
//            preSum[s.length] - preSum[idx] 란 끝에서부터 idx 까지의 1의 개수 이건 유지
            preSum[idx] + s.length - idx - preSum[s.length] + preSum[idx]
        }.min()!!
    }
}