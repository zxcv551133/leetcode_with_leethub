class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        val toOn = ((a or c) - a) and ((b or c) - b)
        val toOffA = (a or c) - c
        val toOffB = (b or c) - c
        println(toOn.toString(2))
        println(toOffA.toString(2))
        println(toOffB.toString(2))
        return toOn.toString(2).count { it == '1' } +
                toOffA.toString(2).count { it == '1' } +
                toOffB.toString(2).count { it == '1' }
    }
}
