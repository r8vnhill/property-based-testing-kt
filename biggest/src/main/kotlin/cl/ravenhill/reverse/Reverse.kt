package cl.ravenhill.reverse

fun reverse(list: List<Int>): List<Int> {
    val reversed = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        reversed.add(list[i])
    }
    return reversed
}
