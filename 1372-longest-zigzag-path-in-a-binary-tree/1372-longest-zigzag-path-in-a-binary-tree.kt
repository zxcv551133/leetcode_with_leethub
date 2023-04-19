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
    fun longestZigZag(root: TreeNode?): Int {
        return longestZigZagDfs(root).third - 1
    }
    
    fun longestZigZagDfs(root: TreeNode?): Triple<Int, Int, Int> {
        if(root == null) {
            return Triple(0, 0, 0)
        }
        
        val leftZig = longestZigZagDfs(root.left)
        val rightZig = longestZigZagDfs(root.right)
        
        return Triple(leftZig.second + 1, 
            rightZig.first + 1,
            kotlin.math.max(
                kotlin.math.max(leftZig.second + 1, rightZig.first + 1),
                kotlin.math.max(leftZig.third, rightZig.third)))
    }
}
