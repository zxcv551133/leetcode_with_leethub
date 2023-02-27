/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        fun dfs(row: Int, col: Int, width: Int): Node = if (width == 1) {
            Node(grid[row][col] == 1, true)
        } else {
            val newWidth = width shr 1
            val topLeft = dfs(row, col, newWidth)
            val topRight = dfs(row, col + newWidth, newWidth)
            val bottomLeft = dfs(row + newWidth, col, newWidth)
            val bottmRight = dfs(row + newWidth, col + newWidth, newWidth)

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottmRight.isLeaf
                && topLeft.`val` == topRight.`val` && topRight.`val` == bottomLeft.`val` && bottomLeft.`val` == bottmRight.`val`) {
                Node(topLeft.`val`, true)
            } else {
                val res = Node(true, false)
                res.topLeft = topLeft
                res.topRight = topRight
                res.bottomLeft = bottomLeft
                res.bottomRight = bottmRight
                res
            }
        }
        return dfs(0, 0, grid.size)
    }
}
