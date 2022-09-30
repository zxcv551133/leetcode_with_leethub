class Solution {
    data class Point(
        val x: Int,
        val height: Int,
        val isStart: Boolean
    ): Comparable<Point> {
        override fun compareTo(other: Point): Int {
            if (x != other.x) {
                return x.compareTo(other.x)
            } else {
                return (if (isStart) -height else height) - if (other.isStart) -other.height else other.height
            }
        }
    }
    
    fun getSkyline(A: Array<IntArray>): List<List<Int>> {
        val len = A.size
        val points = ArrayList<Point>(len * 2)
        val ans = ArrayList<List<Int>>()
        for ((start, end, h) in A) {
            points.add(Point(start, h, true))
            points.add(Point(end, h, false))
        }
        points.sort()
        val map = TreeMap<Int, Int>()
        map[0] = 1
        var prevMaxHeight = 0
        for ((x, h, isStart) in points) {
            if (isStart) {
                map.merge(h, 1) { a, b -> a + b } // add map[h] = 1 if key is absent, increment by 1 if present
            } else {
                map.merge(h, 1) { a, b -> a - b } // decrement by 1
                if (map[h]!! == 0) map.remove(h)
            }
            val currentMaxHeight = map.lastKey()
            if (prevMaxHeight != currentMaxHeight) {
                ans.add(listOf(x, currentMaxHeight))
                prevMaxHeight = currentMaxHeight
            }
        }
        return ans
    }
}