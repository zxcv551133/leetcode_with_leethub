class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        fun floodFillTarget(r: Int, c: Int, currentColor: Int) {
            if (!(r < 0 || r >= image.size || c < 0 || c >= image[0].size)) {
                if (newColor != currentColor && image[r][c] == currentColor) {
                    image[r][c] = newColor
                    floodFillTarget(r + 1, c, currentColor)
                    floodFillTarget(r - 1, c, currentColor)
                    floodFillTarget(r, c + 1, currentColor)
                    floodFillTarget(r, c - 1, currentColor)
                }
            }
        }
        floodFillTarget(sr, sc, image[sr][sc])
        return image
    }
}