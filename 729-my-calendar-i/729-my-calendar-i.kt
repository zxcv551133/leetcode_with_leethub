class MyCalendar() {
    private val treeSet = java.util.TreeSet<Pair<Int, Int>>(Comparator { o1, o2 ->
        if (o1.first == o2.first) {
            return@Comparator compareValues(o1.second, o2.second)
        } else {
            return@Comparator compareValues(o1.first, o2.first)
        }
    })

    fun book(start: Int, end: Int): Boolean {
        val upper = treeSet.lower(Pair(end, end))

        return if ((upper?.second ?: 0) <= start) {
            treeSet.add(Pair(start, end))
            true
        } else {
            false
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */