class Solution {
    fun totalFruit(fruits: IntArray): Int {
        var left = 0
        var maxFruit = 0
        val currentFruit = mutableMapOf<Int, Int>()
        for (right in fruits.indices) {
            val fruit = currentFruit.getOrDefault(fruits[right], 0)
            currentFruit[fruits[right]] = fruit + 1
            while(currentFruit.size > 2) {
                val leftFruit = currentFruit[fruits[left]]!!
                currentFruit[fruits[left]] = leftFruit - 1
                if(currentFruit[fruits[left]] == 0) currentFruit.remove(fruits[left])
                left++
            }
            maxFruit = kotlin.math.max(maxFruit, currentFruit.values.sum())
        }
        return maxFruit
    }
}