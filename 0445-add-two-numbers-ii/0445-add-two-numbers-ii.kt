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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()
        var currentNode1 = l1
        var currentNode2 = l2
        val retQueue = LinkedList<Int>()
        while (currentNode1 != null) {
            stack1.push(currentNode1.`val`)
            currentNode1 = currentNode1.next
        }
        while (currentNode2 != null) {
            stack2.push(currentNode2.`val`)
            currentNode2 = currentNode2.next
        }

        var toUp = 0
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            val current1 = if(stack1.isNotEmpty()) stack1.pop() else 0
            val current2 = if(stack2.isNotEmpty()) stack2.pop() else 0
            val current = toUp + current1 + current2
            toUp = current / 10
            retQueue.add(current % 10)
        }
        if (toUp != 0) retQueue.add(toUp)

        var retNode: ListNode? = null
        while (retQueue.isNotEmpty()) {

            val currentVal = retQueue.poll()
            val newNode = ListNode(currentVal)
            newNode.next = retNode
            retNode = newNode
        }

        return retNode
    }
}
