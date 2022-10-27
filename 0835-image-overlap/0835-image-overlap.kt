class Solution {
    fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        val largeImg = Array(img1.size * 3) { Array(img1.size * 3) { 0 } }
        for (i in img1.indices) {
            for (j in img1.indices) {
                largeImg[i + img1.size][j + img1.size] = img1[i][j]
            }
        }
        var maxOverlap = 0
        for (i in (0 until img1.size * 2)) {
            for (j in (0 until img1.size * 2)) {
                var count = 0
                for (l in img1.indices) {
                    for (k in img1.indices) {
                        if (img2[l][k] == 1 && largeImg[i + l][j + k] == img2[l][k]) {
                            count++
                        }
                    }
                }
                maxOverlap = maxOf(maxOverlap, count)
            }
        }
        return maxOverlap
    }
}