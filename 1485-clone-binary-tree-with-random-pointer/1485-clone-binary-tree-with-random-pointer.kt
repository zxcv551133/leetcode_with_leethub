/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomBinaryTree(root: Node?): NodeCopy? {
        if (root == null) return null

        val copies = mutableMapOf<Node, NodeCopy>()

        fun Node?.deepCopy(): NodeCopy? {
            if (this == null) return null
            if (this in copies) return copies[this]!!

            val copy = shallowCopy()
            copies[this] = copy
            
            copy.random = random.deepCopy()
            copy.left = left.deepCopy()
            copy.right = right.deepCopy()

            return copy
        }

        return root.deepCopy()
    }

    fun Node.shallowCopy(): NodeCopy = NodeCopy(`val`)
}
