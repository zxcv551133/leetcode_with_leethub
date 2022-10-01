class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
//         TODO: algorithm 으로 구현 pop_count 참고
        return Integer.toBinaryString(n).count { it == '1' }
    }
}