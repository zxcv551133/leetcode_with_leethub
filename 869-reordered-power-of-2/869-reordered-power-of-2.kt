class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val power2set = mutableSetOf<Int>()
        for (i in 0..31) {
            power2set.add(1 shl i)
        }
        val power2stringSet = power2set.map { it.toString().toCharArray().sorted() }
        return power2stringSet.contains(n.toString().toCharArray().sorted())
    }
}