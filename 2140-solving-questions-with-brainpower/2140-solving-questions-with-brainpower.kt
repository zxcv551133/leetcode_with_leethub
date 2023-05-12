class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val queue = PriorityQueue<Pair<Long, Int>>(Comparator<Pair<Long, Int>> { a, b -> (a.second - b.second) })
        val dp = Array(questions.size + 1) { Pair(0L, 0) }
        for (i in questions.indices) {
            val duration = questions[i][1]
            val point = questions[i][0].toLong()
            var maxPointPair = Pair(0L, 0)
            while(queue.isNotEmpty() && queue.peek().second < i) {
                val current = queue.poll()
                if(maxPointPair.first < current.first) maxPointPair = current
            }
            // println("$i $maxPointPair")
            dp[i] = Pair(point + maxPointPair.first, duration + i)
            queue.add(maxPointPair)
            queue.add(dp[i])
        }
        val maxPoint = dp.maxBy { (point, _) -> point }!!.first
        return maxPoint
    }
}
