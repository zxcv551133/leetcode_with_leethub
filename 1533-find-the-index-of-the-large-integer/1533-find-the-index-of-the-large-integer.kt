/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     fun compareSub(l: Int, r: Int, x: Int, y: Int): Int {}
 *
 *     // Returns the length of the array
 *     fun length(): Int {}
 * }
 */

class Solution {
    fun getIndex(reader: ArrayReader): Int {
        val arrayLength = reader.length()
        fun optimistic(leftSt: Int, leftEd: Int, rightSt: Int, rightEd: Int): Int {
            if (rightEd - leftSt == 1) {
                return when (reader.compareSub(leftSt, leftEd, rightSt, rightEd)) {
                    1 -> leftSt
                    -1 -> rightEd
                    else -> -1
                }
            } else if (rightEd - leftSt == 2) {
                val opt = optimistic(leftSt, leftEd, rightSt, rightEd - 1)
                return if (opt == -1) rightEd else opt
            } else if ((rightEd - leftSt) % 2 == 0) {
                return when (reader.compareSub(leftSt, leftEd, rightSt, rightEd - 1)) {
                    0 -> rightEd
                    1 -> optimistic(leftSt, (leftSt + leftEd - 1) / 2, (leftSt + leftEd - 1) / 2 + 1, leftEd)
                    -1 -> optimistic(rightSt, (rightSt + rightEd - 1) / 2, (rightSt + rightEd - 1) / 2 + 1, rightEd)
                    else -> -1
                }
            } else {
                return when (reader.compareSub(leftSt, leftEd, rightSt, rightEd)) {
                    1 -> optimistic(leftSt, (leftSt + leftEd - 1) / 2, (leftSt + leftEd - 1) / 2 + 1, leftEd)
                    -1 -> optimistic(rightSt, (rightSt + rightEd - 1) / 2, (rightSt + rightEd - 1) / 2 + 1, rightEd)
                    else -> -1
                }
            }
        }
        return if (arrayLength == 1) 1
        else optimistic(0, arrayLength / 2 - 1, arrayLength / 2, arrayLength - 1)
    }
}