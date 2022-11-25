class Solution {
    fun smallestEvenMultiple(n: Int): Int {
        return if (n % 2 == 1) n * 2 else n
    }
}