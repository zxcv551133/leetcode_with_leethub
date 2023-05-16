/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def swapPairs(head: ListNode): ListNode = {
    if(head == null) null
    else swapPair(head)
  }
  def swapPair(head: ListNode): ListNode = {
    head.next match {
      case null => head
      case _ => {
        val headnextnext = head.next.next;
        val headnext = head.next;
        headnext.next = head;
        head.next = headnextnext;

        headnextnext match {
          case null => ;
          case _ => head.next = swapPair(headnextnext)
        }
        headnext;
      }
    }
  }

}
