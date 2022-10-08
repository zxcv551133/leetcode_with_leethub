import java.util.*

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val pq = PriorityQueue<Pair<Int, Int>>((compareBy<Pair<Int, Int>> { - it.first } ))
        for (i in 0 until k) {
            pq.add(Pair(nums[i], i))
        }
        val firstMax = pq.peek().first
        val ans = (1..nums.size - k).map {
            pq.add(Pair(nums[it + k - 1], it + k - 1))
            while (pq.peek().second < it) {
                pq.poll()
            }
            pq.peek().first
        }
        return (listOf(firstMax) + ans).toIntArray()
    }
}