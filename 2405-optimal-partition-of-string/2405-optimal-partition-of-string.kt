class Solution {
    fun partitionString(s: String): Int {
        return s.fold(Pair(mutableSetOf<Char>(), 1)) { (set, cnt), c ->
            if(set.contains(c)) {
                Pair(mutableSetOf(c), cnt + 1)
            } else {
                set.add(c)
                Pair(set, cnt)
            }
        }.second
    }
}
