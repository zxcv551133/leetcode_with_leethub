/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var lo = 1
        var hi = n
        var mi = lo / 2 + hi / 2 + 1
        while (true) {
            val guessVal = guess(mi)
            val guessVal2 = guess(mi - 1)
            if (guessVal == 0) return mi
            if (guessVal2 == 0) return mi - 1
            if (guessVal == 1) {
                lo = mi
            } else {
                hi = mi
            }
            mi = lo / 2 + hi / 2 + 1
        }
    }
}