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
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return dfsDiameter(root).second
    }

    private fun dfsDiameter(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return Pair(-1, -1)
        val left = dfsDiameter(root.left)
        val right = dfsDiameter(root.right)
        val maxLength = kotlin.math.max(left.first + 1, right.first + 1)
        val maxDiameter = listOf(left.second, right.second, left.first + right.first + 2).max()!!
        return Pair(maxLength, maxDiameter)
    }
}