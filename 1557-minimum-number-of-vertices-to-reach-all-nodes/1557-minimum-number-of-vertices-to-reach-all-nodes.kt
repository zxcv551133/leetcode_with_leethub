class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val mutableSet = (0 until n).toMutableSet()
        for ((st, ed) in edges) {
            mutableSet.remove(ed)
        }
        return mutableSet.toList()
    }
}
