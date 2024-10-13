package cl.ravenhill.biggest

fun biggest(list: List<Int>) = if (list.isEmpty()) {
    Int.MIN_VALUE
} else {
    var biggest = list[0]
    for (number in list) {
        if (number > biggest) {
            biggest = number
        }
    }
    biggest
}
