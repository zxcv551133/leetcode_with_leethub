class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val zipped = coordinates.zip(coordinates.drop(1))
        val pairZipped = zipped.map { (ar1, ar2) ->
            val (x1, y1) = ar1
            val (x2, y2) = ar2
            val xDiff = x1 - x2
            val yDiff = y1 - y2
            val gcd = getGcd(kotlin.math.abs(x1 - x2), kotlin.math.abs(y1 - y2))
            val t = Pair(xDiff / gcd, yDiff / gcd)
            println("$x1 $x2 $y1 $y2 $t")
            listOf(Pair(xDiff / gcd, yDiff / gcd), Pair(- xDiff / gcd, - yDiff / gcd))
        }
        return pairZipped.flatten().toSet().size <= 2
    }

    fun getGcd(a: Int, b: Int): Int {
        if(a > b) return getGcd(b, a)
        if(a == 0) return b
        return getGcd(b % a, a)
    }
}
