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
    fun isValidBST(root: TreeNode?): Boolean {

        return isValidBSTRecurs(
            root!!.left,
            maxVal = Int.MIN_VALUE.toLong() - 1,
            minVal = root.`val`.toLong()
        ) && isValidBSTRecurs(
            root.right,
            root.`val`.toLong(),
            minVal = Int.MAX_VALUE.toLong() + 1
        )
    }

    fun isValidBSTRecurs(root: TreeNode?, maxVal: Long, minVal: Long): Boolean {
        if (root == null) {
            return true
        }
        return if (root.`val` in (maxVal + 1) until minVal) {
            isValidBSTRecurs(root.left, maxVal, root.`val`.toLong()) && isValidBSTRecurs(
                root.right,
                root.`val`.toLong(),
                minVal
            )
        } else {
            false
        }
    }
}