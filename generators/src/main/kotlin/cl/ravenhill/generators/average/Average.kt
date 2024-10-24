package cl.ravenhill.generators.average

fun average(list: List<Double>) =
    list.fold(0.0) { acc, number ->
        acc + number / list.size
    }
