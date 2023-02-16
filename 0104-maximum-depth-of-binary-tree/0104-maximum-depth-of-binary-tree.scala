/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
def maxDepth(root: TreeNode): Int = {
    if(root == null) 0
    else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }
}