class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val graphInverse = Array(graph.size) { mutableListOf<Int>() }
        for (st in graph.indices) {
            for (ed in graph[st]) {
                graphInverse[ed].add(st)
            }
        }

        val safeNodes = mutableSetOf<Int>()
        for (i in graph.indices) {
            if (graph[i].isEmpty()) {
                safeNodes.add(i)
            }
        }

        val q: Queue<Int> = LinkedList<Int>()
        for (safeNode in safeNodes) {
            q.add(safeNode)
        }

        while (!q.isEmpty()) {
            val current = q.poll()
            if (!graph[current].all { safeNodes.contains(it) }) continue
            safeNodes.add(current)
            
            for (next in graphInverse[current]) {
                q.add(next)
            }
        }

        return safeNodes.toList().sorted()
    }
}
