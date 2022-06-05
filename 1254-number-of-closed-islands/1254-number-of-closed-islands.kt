class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        val coordSet = mutableSetOf<Pair<Int, Int>>()
        var ans = 0
        fun checkIslands(r: Int, c: Int, isSub: Boolean, isIsolated: Boolean) {
            if (!(r < 0 || r >= grid.size || c < 0 || c >= grid[0].size)) {
                if (!coordSet.contains(Pair(r, c)) && grid[r][c] == 0) {
                    coordSet.add(Pair(r, c))
                    if (!isSub && isIsolated) {
                        ans += 1
                    }
                    checkIslands(r + 1, c, true, isIsolated)
                    checkIslands(r - 1, c, true, isIsolated)
                    checkIslands(r, c + 1, true, isIsolated)
                    checkIslands(r, c - 1, true, isIsolated)
                }
            }
        }
        grid.indices.forEach { r ->
            grid[r].indices.forEach { c ->
                if (r == 0 || r == grid.size - 1 || c == 0 || c == grid[0].size - 1) {
                    checkIslands(r, c, isSub = false, isIsolated = false)
                }
            }
        }

        grid.indices.forEach { r ->
            grid[r].indices.forEach { c ->
                checkIslands(r, c, isSub = false, isIsolated = true)
            }
        }
        return ans
    }
}