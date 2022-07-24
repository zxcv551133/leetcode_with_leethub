class Solution {
    fun maxScoreSightseeingPair(values: IntArray): Int {
        val zippedValues = values.zip(values.indices)
        val zippedPatched = zippedValues.map { (value, idx) ->
            Pair(value - idx, idx)
        }
        val lambda = { a: Int, b: Int ->
            when {
                a < b -> 1
                a > b -> -1
                else -> 0
            }
        }
        val pq = PriorityQueue(Comparator<Pair<Int, Int>> { a, b ->
            when {
                a.first != b.first -> lambda(a.first, b.first)
                else -> lambda(a.second, b.second)
            }
        })

        pq.addAll(zippedPatched)

        var maxVal = 0
        zippedPatched.forEach { (value, idx) ->
            if (idx < values.size - 1) {
                while (pq.peek().second <= idx) {
                    pq.poll()
                }
                val pqPeek = pq.peek()
                val currentMaxVal = pqPeek.first + value + idx * 2
                maxVal = kotlin.math.max(maxVal, currentMaxVal)
            }
        }

        return maxVal
    }
}