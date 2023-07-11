/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    
    val graph = mutableMapOf<Int, MutableSet<Int>>()

    val mutableSet = mutableSetOf<Int>()
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        buildGraph(root!!)
        dfs(target!!.`val`, k, target.`val`)
        
        return mutableSet.toList()
    }
    
    fun buildGraph(root: TreeNode) {
        if(root.left != null) {
            if(graph[root.`val`] == null) graph[root.`val`] = mutableSetOf()
            if(graph[root.left!!.`val`] == null) graph[root.left!!.`val`] = mutableSetOf()
            graph[root.`val`]!!.add(root.left!!.`val`)
            graph[root.left!!.`val`]!!.add(root.`val`)
            buildGraph(root.left!!)
        }
        
        if(root.right != null) {
            if(graph[root.`val`] == null) graph[root.`val`] = mutableSetOf()
            if(graph[root.right!!.`val`] == null) graph[root.right!!.`val`] = mutableSetOf()
            graph[root.`val`]!!.add(root.right!!.`val`)
            graph[root.right!!.`val`]!!.add(root.`val`)
            buildGraph(root.right!!)
        }
        
    }
    
    fun dfs(root: Int, distance: Int, from: Int) {
        if(distance == 0) {
            mutableSet.add(root)
            return
        }
        for (next in graph.getOrDefault(root, mutableSetOf())) {
            if(next == from) continue
            dfs(next, distance - 1, root)
        }
    }
}
