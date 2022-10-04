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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return dfsPathSum(root, 0, targetSum)
    }

    private fun dfsPathSum(root: TreeNode?, accSum: Int, targetSum: Int): Boolean {
        if(root == null) return false
        if(root.left == null && root.right == null) {
            return accSum + root.`val` == targetSum
        }
        val left = dfsPathSum(root.left, accSum + root.`val`, targetSum)
        val right = dfsPathSum(root.right, accSum + root.`val`, targetSum)
        return left || right
    }
}