class Solution {
    fun numTilings(n: Int): Int {
        val mod = 1000000007
        val partial = Array<Long>(n + 2) { 0 }
        val full = Array<Long>(n + 2) { 0 }
        partial[2] = 1
        full[1] = 1
        full[2] = 2
        for (i in 3..n) {
            partial[i] = (partial[i - 1] + full[i - 2]) % mod
            full[i] = (full[i - 1] + full[i - 2] + 2 * partial[i - 1]) % mod
        }
        return full[n].toInt()
    }
}