class Solution {
    fun minimumHealth(damage: IntArray, armor: Int): Long {
        val sumOfDamage = damage.map { it.toLong() }.sum()
        val maxOfDamage = damage.max()!!
        val armorProtect = minOf(maxOfDamage, armor)
        return sumOfDamage - armorProtect + 1
    }

}