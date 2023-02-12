class Solution {
    lateinit var fuelGraph: Array<IntArray>
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val graph = Array<MutableList<Int>>(roads.size + 1) { mutableListOf() }
        for (roadPair in roads) {
            val a = roadPair[0]
            val b = roadPair[1]
            graph[a].add(b)
            graph[b].add(a)
        }
        fuelGraph = graph.map { it.toIntArray() }.toTypedArray()

        return dfs(0, -1, seats).second
    }

    private fun dfs(currentPos: Int, parentPos: Int, seats: Int): Pair<Int, Long> {
        val pairSum = fuelGraph[currentPos]
            .filterNot { it == parentPos }
            .map { dfs(it, currentPos, seats) }
            .fold(Pair(1, 0L)) { a, b ->
                Pair(
                    a.first + b.first,
                    a.second + b.second + (b.first + seats - 1) / seats
                )
            }
        return pairSum
    }
}
