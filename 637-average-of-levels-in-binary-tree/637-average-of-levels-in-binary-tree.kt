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
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        return queueWithCount(listOf(root!!), listOf()).toDoubleArray()
    }

    fun queueWithCount(queue: List<TreeNode>, currentList: List<Double>): List<Double> {
        if (queue.isEmpty()) {
            return currentList
        }
        val sumValue = queue.map { it.`val`.toDouble() }.sum()

        val nextLeft = queue.flatMap { if (it.left == null) listOf() else listOf(it.left!!) }
        val nextRight = queue.flatMap { if (it.right == null) listOf() else listOf(it.right!!) }

        val average = sumValue / queue.size.toDouble()
        return queueWithCount(nextLeft + nextRight, currentList + average)
    }

}