class Solution {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {

        var leftT = -1
        var leftF = -1

        var fCount = 0
        var tCount = 0

        var ret = 0

        for (i in answerKey.indices) {
            if (answerKey[i] == 'T') {
                tCount++
            } else {
                fCount++
            }

            while (fCount > k) {
                leftT++
                if (answerKey[leftT] == 'F') {
                    fCount--
                }
            }

            while (tCount > k) {
                leftF++
                if (answerKey[leftF] == 'T') {
                    tCount--
                }
            }

            ret = kotlin.math.max(ret, i - leftT)
            ret = kotlin.math.max(ret, i - leftF)
        }

        return ret
    }
}
