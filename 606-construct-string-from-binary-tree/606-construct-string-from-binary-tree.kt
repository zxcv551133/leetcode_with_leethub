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
    fun tree2str(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val left = "(" + tree2str(root.left) + ")"
        val right = "(" + tree2str(root.right) + ")"
        return if (left == "()" && right == "()") {
            root.`val`.toString()
        } else if (right == "()") {
            root.`val`.toString() + left
        } else {
            root.`val`.toString() + left + right
        }
    }
}