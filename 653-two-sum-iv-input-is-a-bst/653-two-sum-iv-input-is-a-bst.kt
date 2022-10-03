/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val currentMap = dfsToList(root).groupBy { it }.mapValues { (_, v) -> v.size }
        currentMap.forEach { (key, value) ->
            val other = k - key
            if (key == other) {
                if (value > 1) {
                    return true
                }
            } else {
                if (currentMap.contains(other)) {
                    return true
                }
            }
        }
        return false
    }
    
    fun dfsToList(root: TreeNode?): List<Int> {
        return if (root == null) {
            listOf()
        } else {
            listOf(root.`val`) + dfsToList(root.left) + dfsToList(root.right)
        }
    }
}