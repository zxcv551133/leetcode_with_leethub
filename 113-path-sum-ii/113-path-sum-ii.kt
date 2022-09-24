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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        return dfs(root, listOf(), 0, targetSum)
    }

    private fun dfs(root: TreeNode?, acc: List<Int>, accSum: Int, targetSum: Int): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        if (root.left == null && root.right == null) {
            return if (root.`val` + accSum == targetSum) {
                listOf(acc + root.`val`)
            } else {
                listOf()
            }
        }
        val left = dfs(root.left, acc + root.`val`, accSum + root.`val`, targetSum)
        val right = dfs(root.right, acc + root.`val`, accSum + root.`val`, targetSum)
        return left + right
    }
}