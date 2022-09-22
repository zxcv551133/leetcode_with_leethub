class Solution {
    fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
        return if (sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
    }

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return permutation(nums.toList()).toSet().toList()
    }
}