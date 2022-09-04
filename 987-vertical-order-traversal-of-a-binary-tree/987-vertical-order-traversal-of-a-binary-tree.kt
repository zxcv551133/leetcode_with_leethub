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
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val allValues = dfsTree(root, Pair(0, 0))

        return allValues
            .groupBy { it.second }
            .mapValues { (_, v) ->
                v.sortedWith(compareBy({ it.first }, { it.third }))
                    .map { it.third }
            }
            .toSortedMap()
            .values.toList()
    }

    private fun dfsTree(root: TreeNode?, currentCoordinate: Pair<Int, Int>): List<Triple<Int, Int, Int>> {
        if (root == null) {
            return listOf()
        }
        val current = Triple(currentCoordinate.first, currentCoordinate.second, root.`val`)
        val leftList = dfsTree(root.left, Pair(currentCoordinate.first + 1, currentCoordinate.second - 1))
        val rightList = dfsTree(root.right, Pair(currentCoordinate.first + 1, currentCoordinate.second + 1))
        return leftList + rightList + current
    }
}