class Solution {
    lateinit var visited: IntArray
    
    fun isBipartite(graph: Array<IntArray>): Boolean {
        visited = IntArray(graph.size)
        graph.indices.forEach {
            if(visited[it] == 0 && !dfs(graph, it, visited[it] % 2 + 1)) return false
        }
        return true
    }

    private fun dfs(graph: Array<IntArray>, node: Int, beforeNodeSide: Int): Boolean {
        if(visited[node] == beforeNodeSide) return false
        if(visited[node] != 0) return true

        visited[node] = beforeNodeSide % 2 + 1

        for (next in graph[node]) {
            val dfsRet = dfs(graph, next, visited[node])
            if(!dfsRet) return false
        }
        return true
    }
}
