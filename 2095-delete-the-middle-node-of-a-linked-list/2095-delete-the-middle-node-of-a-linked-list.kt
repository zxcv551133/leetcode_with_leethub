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
    fun deleteMiddle(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        var preSlow = head
        while (fast != null && fast!!.next != null) {
            fast = fast.next!!.next
            preSlow = slow
            slow = slow!!.next
        }
        return if (head == slow) {
            head!!.next
        } else {
            preSlow!!.next = slow!!.next
            head
        }
    }
}