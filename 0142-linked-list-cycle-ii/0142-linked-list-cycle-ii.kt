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
    fun detectCycle(head: ListNode?): ListNode? {
        var hare = head
        var tort = head
        do {
            if(hare == null) {
                return null
            }
            if(hare.next == null) {
                return null
            }
            if(hare.next!!.next == null) {
                return null
            }

            hare = hare.next!!.next
            tort = tort!!.next
        } while(hare != tort)

        var newSt = head
        while(tort != newSt) {
            tort = tort!!.next
            newSt = newSt!!.next
        }
        return newSt
    }
}
