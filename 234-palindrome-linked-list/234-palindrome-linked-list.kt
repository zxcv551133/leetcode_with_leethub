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
    fun isPalindrome(head: ListNode?): Boolean {
        if (head!!.next == null) {
            return true
        }

        var slow = head
        var fast = head

        var count = 0
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            count += 1
        }


        var past: ListNode? = null
        var pointer = slow

        while (pointer != null) {
            val temp = pointer
            pointer = pointer.next
            temp.next = past
            past = temp
        }
        var newPoint = head
        for (i in 0 until count) {
            if (past!!.`val` != newPoint!!.`val`) {
                return false
            }
            past = past.next
            newPoint = newPoint.next
        }
        return true
    }
}