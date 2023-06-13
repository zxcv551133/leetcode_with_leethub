class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val mutableMap = HashMap<String, Int>()
        var ret = 0
        for (row in grid) {
            val rowString = row.toList().toString()
            mutableMap[rowString] = mutableMap.getOrDefault(rowString, 0) + 1
        }
        for (i in grid.indices) {
            val mutableList = mutableListOf<Int>()
            for(j in grid.indices) {
                mutableList.add(grid[j][i])
            }
            val colString = mutableList.toList().toString()
            ret += mutableMap.getOrDefault(colString, 0)
        }
        return ret
    }
}
