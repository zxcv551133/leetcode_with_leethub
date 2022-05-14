class Solution {
    fun romanToInt(s: String): Int {
        val romanMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        return s.fold(Pair(0, 1000)) { (number, last), it ->
            val value = romanMap[it] ?: 0
            if (value > last) {
                Pair(number - last * 2 + value, value)
            } else {
                Pair(number + value, value)
            }
        }.first
    }
}