class Solution {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        val appleTrees = hasApple.toTypedArray()

        val graph = Array(n) { mutableListOf<Int>() }


        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        graph[0].add(-1)

        return maxOf(appleDfs(0, -1, graph, appleTrees) - 2, 0)
    }

    private fun appleDfs(currentIdx: Int, parentIdx: Int, graph: Array<MutableList<Int>>, appleTrees: Array<Boolean>): Int {
        if(graph[currentIdx].size == 1) {
            return if(appleTrees[currentIdx]) 2 else 0
        }
        var childValue = 0
        for (edge in graph[currentIdx]) {
            if (edge == parentIdx) continue
            childValue += appleDfs(edge, currentIdx, graph, appleTrees)
        }
        val currentValue = if(appleTrees[currentIdx] || childValue > 0) 2 else 0

        return childValue + currentValue
    }
}