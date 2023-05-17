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
    fun pairSum(head: ListNode?): Int {
        var hare: ListNode? = head!!
        var tort = head

        while(hare?.next != null) {
            hare = hare.next!!.next
            tort = tort!!.next
        }

        var prev: ListNode? = null

        while(tort != null) {
            val next = tort.next
            tort.next = prev
            prev = tort
            tort = next
        }

        var point = head
        var maxRet = Int.MIN_VALUE
        while(prev != null) {
            maxRet = kotlin.math.max(maxRet, point!!.`val` + prev.`val`)
            point = point.next
            prev = prev.next
        }
        
        return maxRet
    }
}
