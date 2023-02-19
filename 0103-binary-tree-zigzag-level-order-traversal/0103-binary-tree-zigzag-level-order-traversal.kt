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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()

        val deque: Deque<TreeNode?> = LinkedList()
        deque.addFirst(root)
        deque.addLast(null)
        
        val ret = LinkedList<List<Int>>()
        var direction = true
        val currentLevelList = LinkedList<Int>()
        while (deque.isNotEmpty()) {
            val curNode = deque.pollFirst()
            if (curNode == null) {
                ret.add(currentLevelList.toList())
                currentLevelList.clear()
                if (deque.isNotEmpty()) deque.addLast(null)
                direction = !direction
            } else {
                if (direction) {
                    currentLevelList.addLast(curNode.`val`)
                } else {
                    currentLevelList.addFirst(curNode.`val`)
                }

                if (curNode.left != null) {
                    deque.addLast(curNode.left)
                }
                if (curNode.right != null) {
                    deque.addLast(curNode.right)
                }
            }
        }

        return ret.toList()
    }
}