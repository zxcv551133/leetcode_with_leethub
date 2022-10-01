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
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val c1 = dfs(root, 0, 1, x)!!
        val c2 = dfs(root, 0, 1, y)!!
        return c1.first != c2.first && c1.second == c2.second
    }

    private fun dfs(root: TreeNode?, parent: Int, depth: Int, target: Int): Pair<Int, Int>? {
        if (root == null) {
            return null
        }
        if (root.`val` == target) {
            return Pair(parent, depth)
        }
        println(Pair(parent,  depth))
        val left = dfs(root.left, root.`val`, depth + 1, target)
        val right = dfs(root.right, root.`val`, depth + 1, target)
        val list = listOfNotNull(left, right)
        return list.firstOrNull()
    }
}