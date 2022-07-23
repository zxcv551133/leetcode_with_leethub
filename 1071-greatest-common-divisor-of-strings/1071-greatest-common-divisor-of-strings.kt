class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        return if (str1 == str2) {
            str1
        } else if (str1.length < str2.length) {
            gcdOfStrings(str2, str1)
        } else if (str1.substring(0, str2.length) != str2) {
            ""
        } else {
            gcdOfStrings(str1.substring(str2.length, str1.length), str2)
        }
    }
}