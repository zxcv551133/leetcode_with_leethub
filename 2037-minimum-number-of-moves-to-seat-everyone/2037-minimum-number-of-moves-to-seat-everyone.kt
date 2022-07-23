class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        return seats.zip(students).fold(0) { acc, (seat, student) ->
            acc + kotlin.math.abs(seat - student)
        }
    }
}