class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        val visited = Array(n + 1) { false }
        for(road in roads) {
            val (a, b, weight) = road
            graph[a].add(Pair(b, weight))
            graph[b].add(Pair(a, weight))
        }
        minScore(visited, graph, 1)

        return minDist
    }

    var minDist = Int.MAX_VALUE

    fun minScore(visited: Array<Boolean>, graph: Array<MutableList<Pair<Int, Int>>>, currentPos: Int) {
        if(visited[currentPos]) return
        visited[currentPos] = true
        for (node in graph[currentPos]) {
            minDist = kotlin.math.min(node.second, minDist)
            println(node)
            minScore(visited, graph, node.first)
        }
        return
    }
}
