class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val tripleSorted = nums1.zip(nums2)
            .sortedBy { it.second }
            .mapIndexed { idx, (num1, num2) -> Triple(idx.toLong(), num1.toLong(), num2.toLong()) }
        val pq = PriorityQueue<Pair<Long, Long>>(Comparator { a, b -> 
            b.second.compareTo(a.second) })
        val pqIndex = PriorityQueue<Pair<Long, Long>>(Comparator { a, b -> a.first.compareTo(b.first) })
        for(triple in tripleSorted) {
            pq.add(Pair(triple.first, triple.second))
        }
        var currentSum = 0L
        var ret = 0L
        for (i in 0..(nums1.size - k)) {
            val triple = tripleSorted[i]
            val currentIdx = triple.first
            val currentMin = triple.third

            while(pqIndex.isNotEmpty() && pqIndex.peek()!!.first < currentIdx) {
                currentSum -= pqIndex.poll()!!.second
            }
            while(pqIndex.size < k) {
                pqIndex.add(pq.peek())
                currentSum += pq.poll()!!.second
                while(pqIndex.isNotEmpty() && pqIndex.peek()!!.first < currentIdx) {
                    currentSum -= pqIndex.poll()!!.second
                }
            }
            ret = kotlin.math.max(currentSum * currentMin, ret)
        }

        return ret
    }
}
