class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val tokenList = s.split(" ")
        if (tokenList.size != pattern.length) return false
        
        val zipped = pattern.toList().zip(tokenList)
        val mutableMap = mutableMapOf<Char, String>()
        val mutableMapReversed = mutableMapOf<String, Char>()

        zipped.forEach { (key, value) ->
            if (mutableMap.getOrPut(key) { value } != value) {
                return false
            }
            if (mutableMapReversed.getOrPut(value) { key } != key) {
                return false
            }
        }
        return true
    }
}