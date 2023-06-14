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
    fun getMinimumDifference(root: TreeNode?): Int {
        val arr = mutableListOf<Int>()
        dfsMinimumDiff(arr, root)
        val sorted = arr.sorted()
        val zipped = sorted.zipWithNext()
        val minPair = zipped.minBy { (a, b) -> kotlin.math.abs(a - b) }!!
        return kotlin.math.abs(minPair.first - minPair.second)
    }

    fun dfsMinimumDiff(arr: MutableList<Int>, root: TreeNode?) {
        if(root == null) return
        arr.add(root.`val`)
        dfsMinimumDiff(arr, root.left)
        dfsMinimumDiff(arr, root.right)
    }
}
