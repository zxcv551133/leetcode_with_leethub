class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Pair<Int, Boolean>>() }
        for((dep, arr) in connections) {
            adj[dep].add(Pair(arr, false))
            adj[arr].add(Pair(dep, true))
        }
        return dfs(adj, -1, 0)
    }
    
    fun dfs(graph: Array<MutableList<Pair<Int, Boolean>>>, parent: Int, current: Int): Int {
        var cnt = 0
        for((arr, available) in graph[current]) {
            if(arr == parent) continue
            if(!available) cnt++
            cnt += dfs(graph, current, arr)
        }
        return cnt
    }
}
