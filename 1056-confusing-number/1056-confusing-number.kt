class Solution {
    fun confusingNumber(n: Int): Boolean {
        val current = n.toString().map { it.toString().toInt() }
        val rotated = current.reversed().map { rotateNum(it) }
        
        return if (rotated.any { it == null }) {
            false
        } else rotated != current
    }

    private fun rotateNum(n: Int): Int? {
        val rotateMap = listOf(Pair(1, 1), Pair(0, 0), Pair(6, 9), Pair(9, 6), Pair(8, 8)).toMap()
        return rotateMap[n]
    }
}