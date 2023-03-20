class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var cnt = 0
        for(i in flowerbed.indices) {
            if(flowerbed.getOrElse(i - 1) { 0 } == 0 &&
                flowerbed.getOrElse((i + 1)) { 0 } == 0 &&
                flowerbed[i] == 0 ) {
                cnt++
                flowerbed[i] = 1
            }
        }
        return cnt >= n
    }
}
