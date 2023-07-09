class Solution {
    fun largestVariance(s: String): Int {
        val counts = s.groupBy { it }.mapValues { it.value.size }

        var maxVariance = 0

        val dp = Array(26) { IntArray(26) }
        for (major in 'a'..'z') {
            for (minor in 'a'..'z') {
                if (major == minor) continue

                var majorCount = 0
                var minorCount = 0
                var restMinorCount = counts[minor] ?: continue

                for (character in s) {

                    if (character == major) {
                        majorCount++
                    }
                    if (character == minor) {
                        minorCount++
                        restMinorCount--
                    }

                    if (minorCount > 0) {
                        maxVariance = kotlin.math.max(maxVariance, majorCount - minorCount)
                    }

                    if (minorCount > majorCount && restMinorCount > 0) {
                        minorCount = 0
                        majorCount = 0
                    }
                }
            }
        }

        return maxVariance
    }
}
