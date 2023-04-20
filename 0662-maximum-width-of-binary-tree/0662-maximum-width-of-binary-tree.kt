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
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList<Pair<TreeNode, Int>>()
        queue.add(Pair(root!!, 0))

        var maxWidth = 0
        while(queue.isNotEmpty()) {
            val queueSize = queue.size
            var leftMost = Int.MAX_VALUE
            var rightMost = Int.MIN_VALUE
            (0 until queueSize).forEach {
                val (node, idx) = queue.poll()
                leftMost = kotlin.math.min(idx, leftMost)
                rightMost = kotlin.math.max(idx, rightMost)

                if (node.left != null)
                    queue.add(Pair(node.left!!, idx * 2 + 1))
                if (node.right != null)
                    queue.add(Pair(node.right!!, idx * 2 + 2))

            }
            maxWidth = kotlin.math.max(maxWidth, rightMost - leftMost)
        }
        
        return maxWidth + 1
    }
}

