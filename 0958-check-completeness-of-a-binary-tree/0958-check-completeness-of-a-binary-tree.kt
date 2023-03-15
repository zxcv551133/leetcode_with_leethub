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
    fun isCompleteTree(root: TreeNode?): Boolean {
        val mutableMap = mutableMapOf<Int, Int>()
        dfs(mutableMap, root, 0)
        for(i in 0 until mutableMap.size) {
            if(mutableMap[i] == null) return false
        }
        return true
    }

    fun dfs(map: MutableMap<Int, Int>, root: TreeNode?, currentIdx: Int) {
        if(root == null) return

        map[currentIdx] = root.`val`

        dfs(map, root.left, currentIdx * 2 + 1)
        dfs(map, root.right, currentIdx * 2 + 2)
    }
}
