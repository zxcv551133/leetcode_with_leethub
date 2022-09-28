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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val newHead = ListNode(0)
        newHead.next = head
        var slow = newHead
        var fast = newHead
        var count = n
        while (fast.next != null) {
            if (count > 0) {
                count -= 1
            } else {
                slow = slow.next!!
            }
            fast = fast.next!!
        }
        slow.next = slow.next!!.next
        return newHead.next
    }
}