class Solution {
    fun concatenatedBinary(n: Int): Int {
        val modulo = 1000000007
        return (1..n).fold(0.toLong()) { acc, num ->
            val binaryStr = Integer.toBinaryString(num)
            (acc.shl(binaryStr.length) + num) % modulo
        }.toInt()
    }
}