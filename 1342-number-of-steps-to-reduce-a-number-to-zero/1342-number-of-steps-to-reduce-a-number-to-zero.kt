class Solution {
    fun numberOfSteps(num: Int): Int {
//         TODO: tailrec 로 바꾸기
        return if (num == 0) 0
        else if (num % 2 == 0) 1 + numberOfSteps(num / 2)
        else 1 + numberOfSteps(num - 1)
    }
}