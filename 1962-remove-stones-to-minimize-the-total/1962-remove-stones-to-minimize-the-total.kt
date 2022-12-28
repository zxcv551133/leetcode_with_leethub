class Solution {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        for (num in piles) {
            pq.add(num)
        }
        for (i in 1..k) {
            val current = pq.poll()
            pq.add((current + 1) / 2)
        }
        return pq.sum()
    }
}