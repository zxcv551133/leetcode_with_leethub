/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
                fun lowerbound(st: Int, ed: Int): Int {
            val mi = st / 2 + ed / 2 + (st % 2 + ed % 2) / 2
            return if (st + 1 >= ed) {
                ed
            } else if (isBadVersion(mi)) {
                lowerbound(st, mi)
            } else {
                lowerbound(mi, ed)
            }
        }
        return lowerbound(-1, n)
	}
}