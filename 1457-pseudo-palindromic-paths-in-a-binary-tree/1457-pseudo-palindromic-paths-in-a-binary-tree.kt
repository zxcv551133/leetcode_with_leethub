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
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return dfs(root, setOf())
    }

    private fun dfs(root: TreeNode?, acc: Set<Int>): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) {
            return if (acc.contains(root.`val`)) {
                if ((acc - root.`val`).size <= 1) 1 else 0
            } else {
                if (acc.isEmpty()) 1 else 0
            }
        }
        val nextAcc = if (acc.contains(root.`val`)) acc - root.`val` else acc + root.`val`
        return dfs(root.left, nextAcc) + dfs(root.right, nextAcc)
    }
}