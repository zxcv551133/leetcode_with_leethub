class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        val sortedSeats = seats.sorted()
        val sortedStudents = students.sorted()
        return sortedSeats.zip(sortedStudents).map { (seats, students) ->
            kotlin.math.abs(seats - students)
        }.sum()
    }
}