class Solution {
    fun canReorderDoubled(arr: IntArray): Boolean {
        val countNum = arr.groupBy { it }.mapValues { (_, v) -> v.size }.toMutableMap()
        val absSorted = arr.sortedBy { kotlin.math.abs(it) }
        absSorted.forEach { num ->
            val cnt = countNum[num]!!
            println("" + num + " " + cnt)
            if (cnt != 0) {
                if ((countNum[num * 2] ?: 0) < cnt) {
                    return false
                } else {
                    countNum[num * 2] = countNum[num * 2]!! - cnt
                    countNum[num] = 0
                }
            }
        }
        return true
    }
}