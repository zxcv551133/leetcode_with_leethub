class SmallestInfiniteSet() {
    private val treeSet = TreeSet<Int>()
    var pos = 1

    fun popSmallest(): Int {
        treeSet.add(pos++)
        return treeSet.pollFirst()!!
    }

    fun addBack(num: Int) {
        treeSet.add(num)
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */
 