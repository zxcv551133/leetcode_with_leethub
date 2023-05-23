class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        val pq = PriorityQueue<Int>()
        var ret = 0
        for((st, ed) in intervals) {
            while (pq.isNotEmpty() && pq.peek() <= st) {
                pq.poll()
            }
            pq.add(ed)
            ret = kotlin.math.max(ret, pq.size)
        }
        return ret
    }
}
