class Solution {
    fun trap(height: IntArray): Int {
        val leftArray = Array(height.size) { 0 }
        val rightArray = Array(height.size) { 0 }
        leftArray[0] = height[0]
        rightArray[height.size - 1] = height[height.size - 1]

        (1 until height.size).forEach {
            leftArray[it] = kotlin.math.max(leftArray[it - 1], height[it])
        }
        (height.size - 2 downTo 0).forEach {
            rightArray[it] = kotlin.math.max(rightArray[it + 1], height[it])
        }
        
        val minValue = leftArray.zip(rightArray).map { (l, r) ->
            kotlin.math.min(l, r)
        }

        return height.zip(minValue).map { (currentHeight, minV) ->
            if (minV > currentHeight) minV - currentHeight
            else 0
        }.sum()
    }
}