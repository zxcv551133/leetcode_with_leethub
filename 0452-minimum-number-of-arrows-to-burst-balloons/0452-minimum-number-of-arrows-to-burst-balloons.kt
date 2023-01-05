class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[1] }
        
        return points.fold(Pair(1, points[0][1])) { (arrow, initEnd), point ->
            val currentStart = point[0]
            val currentEnd = point[1]

            if(currentStart > initEnd) {
                    Pair(arrow + 1, currentEnd)
            } else {
                Pair(arrow, initEnd)
            }
        }.first
    }
}