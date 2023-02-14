class Solution {
    fun addBinary(a: String, b: String): String {
        val aVal = BigInteger(a, 2)
        val bVal = BigInteger(b, 2)
        return aVal.add(bVal).toString(2)
    }
}