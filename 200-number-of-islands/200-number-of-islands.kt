class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val coordSet = mutableSetOf<Pair<Int, Int>>()
        var ans = 0;
        fun checkIslands(r: Int, c: Int, isSub: Boolean) {
            if (!(r < 0 || r >= grid.size || c < 0 || c >= grid[0].size)) {
                if (!coordSet.contains(Pair(r, c)) && grid[r][c] == '1') {
                    coordSet.add(Pair(r, c))
                    if (!isSub) {
                        ans += 1
                    }
                    checkIslands(r + 1, c, true)
                    checkIslands(r - 1, c, true)
                    checkIslands(r, c + 1, true)
                    checkIslands(r, c - 1, true)
                }
            }
        }
        grid.indices.forEach { r ->
            grid[r].indices.forEach { c ->
                checkIslands(r, c, false)
            }
        }
        return ans
    }
}