class Solution {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val presumMap = sToPresumMap(s)
        return queries.map { query ->
            val left = query[0]
            val right = query[1]
            val leftBar = presumMap.ceilingKey(left)
            val rightBar = presumMap.floorKey(right)
            if(leftBar == null || rightBar == null || leftBar > rightBar) {
                0
            } else {
                presumMap[rightBar]!! - presumMap[leftBar]!!
            }
        }.toIntArray()
    }

    private fun sToPresumMap(s: String): TreeMap<Int, Int> {
        var currentAcc = 0
        var lastBar = -1
        val treeMap = TreeMap<Int, Int>()
        for(i in s.indices) {
            if(s[i] == '|') {
                treeMap[i] = currentAcc
                lastBar = i
            } else {
                currentAcc += 1
            }
        }
        return treeMap
    }
}