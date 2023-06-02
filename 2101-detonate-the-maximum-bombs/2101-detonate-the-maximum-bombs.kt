class Solution {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val graph = makeGraph(bombs)
        return bombs.indices.map {
            dfsDetonation(graph, it, Array(bombs.size) {false})
        }.max()!!
    }

    fun dfsDetonation(graph: Array<kotlin.collections.ArrayList<Int>>, currentIdx: Int, visited: Array<Boolean>): Int {
        if(visited[currentIdx]) return 0
        visited[currentIdx] = true

        var ret = 1
        for(nextNode in graph[currentIdx]) {
            ret += dfsDetonation(graph, nextNode, visited)
        }

        return ret
    }

    fun makeGraph(bombs: Array<IntArray>): Array<kotlin.collections.ArrayList<Int>> {
        val ret = Array(bombs.size) { kotlin.collections.ArrayList<Int>() }
        for(i in bombs.indices) {
            for(j in bombs.indices) {
                if(i == j) continue
                val (x1, y1, r1) = bombs[i]
                val (x2, y2, _) = bombs[j]
                val distSq = getDistanceSquare(x1.toLong(), y1.toLong(), x2.toLong(), y2.toLong())
                val rangeSq = r1.toLong() * r1.toLong()
                if(distSq <= rangeSq ) {
                    ret[i].add(j)
                }
            }
        }

        return ret
    }

    fun getDistanceSquare(x1: Long, y1: Long, x2: Long, y2: Long): Long {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
    }
}