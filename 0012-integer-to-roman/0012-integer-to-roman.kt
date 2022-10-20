class Solution {
    fun intToRoman(num: Int): String {
        val roman = listOf(
            Pair(1000, "M"),
            Pair(900, "CM"),
            Pair(500, "D"),
            Pair(400, "CD"),
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(50, "L"),
            Pair(40, "XL"),
            Pair(10, "X"),
            Pair(9, "IX"),
            Pair(5, "V"),
            Pair(4, "IV"),
            Pair(1, "I")
        )
        
        return roman.fold(Pair("", num)) { (currentStr, leftNum), (value, character) ->
            val repeat = leftNum / value
            val newLeft = leftNum % value
            Pair(currentStr + character.repeat(repeat), newLeft)
        }.first
    }
}