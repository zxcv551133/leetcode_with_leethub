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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        return dfs(root)
    }

    private fun dfs(root: TreeNode?): List<Int> {
        if (root == null) {
            return listOf()
        }
        val left = dfs(root.left)
        val right = dfs(root.right)
        return left + root.`val` + right
    }
}