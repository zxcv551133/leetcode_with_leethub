class Solution {
    fun maxDistance(grid: Array<IntArray>): Int {
        var ans = -1L
        for (i in grid.indices) {
            for (j in grid.indices) {
                if(grid[i][j] == 1) {
                    continue
                }
                var temporaryMinDist = Int.MAX_VALUE.toLong()
                for (k in grid.indices) {
                    for(l in grid.indices) {
                        if(grid[k][l] == 0) {
                            continue
                        }
                        val currentDist = kotlin.math.abs(k - i).toLong() + kotlin.math.abs(l - j).toLong()
                        temporaryMinDist = kotlin.math.min(temporaryMinDist, currentDist)
                    }
                }
                if(temporaryMinDist == Int.MAX_VALUE.toLong()) continue
                ans = kotlin.math.max(temporaryMinDist, ans)
            }
        }

        return ans.toInt()
    }
}