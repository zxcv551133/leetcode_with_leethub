class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val indices = (0 until profits.size).sortedWith(Comparator<Int>{a, b -> capital[b] - capital[a]}).toMutableList();
        val pq = PriorityQueue<Int> { a, b -> b - a }
        var res = w
        repeat(k) {
            while (!indices.isEmpty() && res >= capital[indices.last()])
                pq.offer(profits[indices.removeAt(indices.size - 1)])
            res += pq.poll() ?: 0
        }
        return res
    }
}