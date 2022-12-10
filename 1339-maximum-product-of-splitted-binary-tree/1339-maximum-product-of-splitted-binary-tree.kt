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
    fun maxProduct(root: TreeNode?): Int {
        val totalSum = getSum(root)
        return ((mutableSet.map { it * (totalSum - it) }.max()!!) % 1000000007).toInt()
    }

    private val mutableSet = mutableSetOf<Long>()

    fun getSum(root: TreeNode?): Long {
        val ans = if (root == null) 0 else root.`val` + getSum(root.left) + getSum(root.right)
        mutableSet.add(ans)
        return ans
    }
}