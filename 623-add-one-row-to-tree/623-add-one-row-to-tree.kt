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
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if(depth == 1) {
            val newTree = TreeNode(`val`)
            newTree.left = root
            return newTree
        }
        getDepthNode(root, `val`, depth,1)
        return root
    }

    fun getDepthNode(root: TreeNode?, value: Int, depth: Int, currentDepth: Int) {
        if(root == null) return

        if(currentDepth == depth - 1) {
            val newLeft = TreeNode(value)
            val newRight = TreeNode(value)
            newLeft.left = root.left
            newRight.right = root.right
            root.left = newLeft
            root.right = newRight
            return
        }
        getDepthNode(root.left, value, depth, currentDepth + 1)
        getDepthNode(root.right, value, depth, currentDepth + 1)
    }
}