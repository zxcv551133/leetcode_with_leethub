class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()

        var lo = 0
        var hi = people.size - 1
        var cnt = 0

        while(lo <= hi) {
            if(people[hi] + people[lo] <= limit) {
                hi--
                lo++
            } else {
                hi--
            }
            cnt++
        }
        return cnt
    }
}
