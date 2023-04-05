class Solution {
  fun minimizeArrayValue(nums: IntArray): Int {
    fun can(maxcap: Int): Boolean {
      var surplus = 0L
      for (i in (1 until nums.size).reversed()) {
        if (nums[i] > maxcap) {
          surplus += nums[i] - maxcap
        } else {
          surplus = maxOf(0L, surplus - (maxcap - nums[i]))
        }
      }
      return surplus + nums[0] <= maxcap
    }
    var l = nums[0]
    var h = 1e9.toInt()
    while (l <= h) {
      val m = (l + h) shr 1
      if (can(m))
        h = m - 1
      else
        l = m + 1
    }
    return l
  }
}