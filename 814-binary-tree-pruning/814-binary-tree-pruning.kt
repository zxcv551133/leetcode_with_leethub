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
    fun pruneTree(root: TreeNode?): TreeNode? {
        return if (getSumAndRemove(root) == 0) {
            null
        } else {
            root
        }
    }

    private fun getSumAndRemove(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = getSumAndRemove(root.left)
        val right = getSumAndRemove(root.right)
        if (left == 0) {
            root.left = null
        }
        if (right == 0) {
            root.right = null
        }

        return root.`val` + left + right
    }
}