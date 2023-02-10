class Solution {
    fun maxDistance(grid: Array<IntArray>): Int {
        var ans = -1
        for (i in grid.indices) {
            for (j in grid.indices) {
                if(grid[i][j] == 1) {
                    continue
                }
                var temporaryMinDist = Int.MAX_VALUE
                for (k in grid.indices) {
                    for(l in grid.indices) {
                        if(grid[k][l] == 0) {
                            continue
                        }
                        val currentDist = kotlin.math.abs(k - i) + kotlin.math.abs(l - j)
                        temporaryMinDist = kotlin.math.min(temporaryMinDist, currentDist)
                    }
                }
                if(temporaryMinDist == Int.MAX_VALUE) continue
                ans = kotlin.math.max(temporaryMinDist, ans)
            }
        }

        return ans
    }
}