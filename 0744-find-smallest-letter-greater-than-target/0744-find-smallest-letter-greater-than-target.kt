class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        val treeSet = TreeSet<Char>()
        for(c in letters) treeSet.add(c)
        return if(treeSet.higher(target) == null) letters[0]
        else treeSet.higher(target)!!
    }
}
