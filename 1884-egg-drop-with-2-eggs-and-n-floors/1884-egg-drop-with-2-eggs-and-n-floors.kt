class Solution {
    fun twoEggDrop(n: Int): Int {
        for(i in 0..n) {
            if(i * i + i >= 2 * n) {
                return i
            }
        }
        return -1
    }
}
