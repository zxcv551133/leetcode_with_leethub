class Solution {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val ans = (1..9).flatMap { numsSameConsecDiff(n - 1, k, it) }
            .map { it.toInt() }.toSet()
        return ans.toIntArray()
    }

    fun numsSameConsecDiff(n: Int, k: Int, current: Int): List<String> {
        return if (n == 0) {
            listOf(current.toString())
        } else {
            val lower = if (current - k >= 0) {
                numsSameConsecDiff(n - 1, k, current = current - k)
            } else listOf()
            val upper = if (current + k <= 9) {
                numsSameConsecDiff(n - 1, k, current = current + k)
            } else listOf()
            val cons = lower + upper
            cons.map { current.toString() + it }
        }
    }

}