class TimeMap() {

    private val mutableMap = mutableMapOf<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        val valueMap = mutableMap.getOrPut(key) { TreeMap() }
        valueMap[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val valueMap = mutableMap.getOrElse(key) { TreeMap() }
        val entry = valueMap.floorEntry(timestamp)
        return if (entry == null) {
            ""
        } else {
            entry.value
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */