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
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val rootLeft = root.left
        val rootRight = root.right
        root.left = invertTree(rootRight)
        root.right = invertTree(rootLeft)
        return root
    }
}