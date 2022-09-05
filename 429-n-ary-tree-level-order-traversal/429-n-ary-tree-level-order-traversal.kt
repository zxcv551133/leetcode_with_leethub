/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        return levelOrder(listOf(root), listOf())
    }
    
    private fun levelOrder(currentList: List<Node?>, currentAcc: List<List<Int>>): List<List<Int>> {
        if (currentList.isEmpty()) {
            if (currentAcc.last().isEmpty()) {
                return currentAcc.dropLast(1)
            }
            return currentAcc
        }
        val nextList = currentList.flatMap { node -> node?.children ?: listOf() }
        val nextAcc = currentList.flatMap { node -> if (node == null) listOf() else listOf(node.`val`) }

        return levelOrder(nextList, currentAcc.plusElement(nextAcc))
    }
}