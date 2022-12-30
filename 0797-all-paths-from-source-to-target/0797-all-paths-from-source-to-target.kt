class Solution {
    lateinit var graph: Array<IntArray>
    fun dfs(current: Int, target: Int, currentPath: List<Int>): List<List<Int>> {
        if (current == target) {
            return listOf(currentPath)
        }
        return graph[current].flatMap { dfs(it, target, currentPath + it) }
    }

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        this.graph = graph
        return dfs(0, graph.size - 1, listOf(0))
    }
}