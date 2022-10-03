class Solution {
    data class BalloonConsecutive(val acc: Int, val accSameColor: Int, val maxColor: Int, val currentColor: Char)

    fun minCost(colors: String, neededTime: IntArray): Int {
        val ret = neededTime.zip(colors.toList()).fold(BalloonConsecutive(0, 0, 0, '*')) { balloon, (time, color) ->
            if (color == balloon.currentColor) {
                BalloonConsecutive(
                    balloon.acc,
                    balloon.accSameColor + time,
                    kotlin.math.max(time, balloon.maxColor),
                    color
                )
            } else {
                BalloonConsecutive(balloon.acc + balloon.accSameColor - balloon.maxColor, time, time, color)
            }
        }
        return ret.acc + ret.accSameColor - ret.maxColor
    }
}