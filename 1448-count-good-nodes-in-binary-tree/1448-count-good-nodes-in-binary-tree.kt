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
    fun goodNodes(root: TreeNode?): Int {
        return goodNodes(root, root!!.`val`)
    }

    fun goodNodes(root: TreeNode?, maxValue: Int): Int {
        if (root == null) {
            return 0
        }

        val current = if (root.`val` >= maxValue) 1 else 0

        val left = goodNodes(root.left, kotlin.math.max(root.`val`, maxValue))
        val right = goodNodes(root.right, kotlin.math.max(root.`val`, maxValue))

        return current + left + right
    }
}