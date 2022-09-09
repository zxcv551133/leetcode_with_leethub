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
    fun deepestLeavesSum(root: TreeNode?): Int {
        return levelSum(listOf(root!!), listOf()).last()
    }

    private fun levelSum(nodeList: List<TreeNode>, acc: List<Int>): List<Int> {
        if (nodeList.isEmpty()) return acc
        val currentSum = nodeList.map { it.`val` }.sum()
        val nextNodeList = nodeList.flatMap {
            listOf(it.left, it.right)
        }.filterNotNull()
        return levelSum(nextNodeList, acc + currentSum)
    }
}