class Solution {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val numInt = BigInteger(num.joinToString(""))
        val retString = numInt.add(k.toBigInteger()).toString()
        return retString.map { it.toString().toInt() }
    }
}