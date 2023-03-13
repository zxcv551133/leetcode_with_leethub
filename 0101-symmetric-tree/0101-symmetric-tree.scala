/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def isSymmetric(root:TreeNode):Boolean = {
    if(root == null) return true
    def isEqual(l:TreeNode, r:TreeNode):Boolean = (l,r) match {
      case (null, null) => true
      case (null, _) => false
      case (_, null) => false
      case (x, y) => x.value == y.value && isEqual(x.left, y.right) && isEqual(x.right, y.left)
    }
    isEqual(root.left,root.right)
  }
}