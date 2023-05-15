/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {

        var currentNode = head
        var leftNode: ListNode? = null
        var rightNode: ListNode? = null
        var lengthOfList = 0
        
        while(currentNode != null) {
            lengthOfList++
            if(rightNode != null) {
                rightNode = rightNode.next
            }
            if(lengthOfList == k) {
                rightNode = head
                leftNode = currentNode
            }
            currentNode = currentNode.next
        }
        
        val swapTempVal = leftNode!!.`val`
        leftNode.`val` = rightNode!!.`val`
        rightNode.`val` = swapTempVal
        
        return head
    }
}
