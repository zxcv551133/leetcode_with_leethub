class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }
        val str = countAndSay(n - 1)
        var ret = ""
        var temp = 1
        for (i in 1 until str.length) {
            if (str[i] == str[i - 1]) {
                temp += 1
            } else {
                ret += temp.toString() + str[i - 1]
                temp = 1
            }
        }
        ret += temp.toString() + str[str.length - 1]

        return ret
    }
}