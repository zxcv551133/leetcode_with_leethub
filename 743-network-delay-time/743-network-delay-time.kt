class Solution {
    lateinit var graph: Map<Int, List<Triple<Int, Int, Int>>>
    private val mutableMapWeight = mutableMapOf<Int, Int>()

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        graph = times.map { Triple(it[0], it[1], it[2]) }.groupBy { it.first }
        val list = graph[k] ?: return -1
        mutableMapWeight[k] = 0
        getPath(list)

        return if (mutableMapWeight.size == n) {
            mutableMapWeight.values.max()!!
        } else {
            -1
        }
    }

    private fun getPath(list: List<Triple<Int, Int, Int>>) {
        if (list.isEmpty()) {
            return
        }
        val next = list.flatMap { (dep, arr, weight) ->
            if ((mutableMapWeight[arr] ?: Int.MAX_VALUE) > weight + mutableMapWeight[dep]!!) {
                mutableMapWeight[arr] = weight + mutableMapWeight[dep]!!
                graph[arr] ?: listOf()
            } else {
                listOf()
            }
        }
        getPath(next)
    }
}