class RandomizedSet() {
    private val valueIdxMap = HashMap<Int, Int>()
    private val mutableList = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (valueIdxMap.contains(`val`)) return false
        valueIdxMap[`val`] = valueIdxMap.size
        mutableList.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!valueIdxMap.contains(`val`)) return false
        val lastElement = mutableList.last()
        val idx = valueIdxMap[`val`]!!
        mutableList[idx] = lastElement
        valueIdxMap[lastElement] = idx
        mutableList.removeAt(mutableList.size - 1)
        valueIdxMap.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return mutableList[kotlin.random.Random.nextInt(from=0, until=valueIdxMap.size)]
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */