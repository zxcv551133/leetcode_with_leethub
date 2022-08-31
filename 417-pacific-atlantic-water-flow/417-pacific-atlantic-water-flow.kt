class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val cardinal = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
        val reachableSeed = heights.indices.flatMap { row ->
            heights[0].indices.map { col ->
                val (pacific, atlantic) = when {
                    heights.size == 1 || heights[0].size == 1 -> Pair(true, true)
                    row == 0 && col == heights[0].size - 1 -> Pair(true, true)
                    row == heights.size - 1 && col == 0 -> Pair(true, true)
                    row == 0 || col == 0 -> Pair(true, false)
                    row == heights.size - 1 || col == heights[0].size - 1 -> Pair(false, true)
                    else -> Pair(false, false)
                }
                Pair(Pair(row, col), Pair(pacific, atlantic))
            }
        }

        fun isNotBoundary(row: Int, col: Int): Boolean = when {
            row >= heights.size || row < 0 || col >= heights[0].size || col < 0 -> false
            else -> true
        }

        tailrec fun getReachableSet(seed: Set<Pair<Int, Int>>, visited: Set<Pair<Int, Int>>): Set<Pair<Int, Int>> {
            return when (seed.firstOrNull()) {
                null -> visited
                else -> {
                    val (row, col) = seed.first()
                    val toVisit = cardinal.map {
                        Pair(row + it.first, col + it.second)
                    }.filter { (nextRow, nextCol) ->
                        isNotBoundary(nextRow, nextCol) &&
                                heights[row][col] <= heights[nextRow][nextCol] &&
                                !visited.contains(Pair(nextRow, nextCol))
                    }
                    getReachableSet(seed - Pair(row, col) + toVisit, visited + toVisit)
                }
            }
        }

        val pacificSeed = reachableSeed.filter { it.second.first }.toMap().keys
        val atlanticSeed = reachableSeed.filter { it.second.second }.toMap().keys
        val pacificSet = getReachableSet(pacificSeed, pacificSeed)
        val atlanticSet = getReachableSet(atlanticSeed, atlanticSeed)

        return pacificSet.intersect(atlanticSet).map { it.toList() }.toList()
    }
}