class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        val newGrid = Array(grid.size + 2) { IntArray(grid[0].size + 2) { 0 } }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                newGrid[i + 1][j + 1] = grid[i][j]
            }
        }
        fun checkBoundary(i: Int, j: Int, array: Array<IntArray>): Int {
            val cardinal = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
            return cardinal.map { (row, col) ->
                if (array[i][j] == 1 && array[i + row][j + col] == 0) 1 else 0
            }.sum()
        }
        return grid.indices.flatMap { i ->
            grid[0].indices.map { j ->
                checkBoundary(i + 1, j + 1, newGrid)
            }
        }.sum()
    }
}