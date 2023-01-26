class Solution {
    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {

        val graph = Array(edges.size) { mutableListOf<Int>() }
        for (edge in edges.withIndex()) {
            if(edge.value == -1) continue
            graph[edge.index].add(edge.value)
        }
        val distNo1 = Array(edges.size) { Int.MAX_VALUE / 10 }
        val distNo2 = Array(edges.size) { Int.MAX_VALUE / 10 }

        dfsClosestMeetingNode(graph, distNo1, node1,0)
        dfsClosestMeetingNode(graph, distNo2, node2,0)
        val minValue = distNo1
            .zip(distNo2).map { (a, b) -> kotlin.math.max(a, b) }
            .mapIndexed { idx, v -> Pair(idx, v)}
            .minBy { it.second }!!

        return if(minValue.second >= Int.MAX_VALUE / 10 ) -1
        else minValue.first
    }

    private fun dfsClosestMeetingNode(graph: Array<MutableList<Int>>, dists: Array<Int>, currentNode: Int, currentDist: Int) {
        if(dists[currentNode] <= currentDist) return
        dists[currentNode] = currentDist
        for (edge in graph[currentNode]) {
            dfsClosestMeetingNode(graph, dists, edge, currentDist + 1)
        }
    }
}