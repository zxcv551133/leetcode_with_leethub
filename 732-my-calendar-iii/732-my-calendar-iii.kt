class MyCalendarThree() {

    private val treeMap = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Int {
        treeMap[start] = treeMap.getOrDefault(start, 0) + 1
        treeMap[end] = treeMap.getOrDefault(end, 0) - 1

        return treeMap.values.fold(Pair(0, 0)) { (current, maxValue), value ->
            Pair(current + value, kotlin.math.max(maxValue, current))
        }.second
    }
}


/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * var obj = MyCalendarThree()
 * var param_1 = obj.book(start,end)
 */