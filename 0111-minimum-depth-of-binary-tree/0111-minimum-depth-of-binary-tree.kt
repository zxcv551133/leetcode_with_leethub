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
    fun getMinDepthDfs(root: TreeNode?): Int {
        if(root == null) return 0
        val leftDepth = getMinDepthDfs(root.left)
        val rightDepth = getMinDepthDfs(root.right)
        if(leftDepth == 0) return rightDepth + 1
        if(rightDepth == 0) return leftDepth + 1
        return kotlin.math.min(leftDepth, rightDepth) + 1
    }
    
    fun minDepth(root: TreeNode?): Int {
        return getMinDepthDfs(root)
    }
}
