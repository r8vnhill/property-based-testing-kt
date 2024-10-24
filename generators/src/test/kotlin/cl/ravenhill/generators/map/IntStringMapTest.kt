package cl.ravenhill.generators.map

import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary

typealias IntStringMap = Map<Int, String>

private fun arbIntStringMap(): Arb<IntStringMap> =
    arbitrary { (random, seed) ->
        val map = mutableMapOf<Int, String>()
        val size = random.nextInt(1, 100)
        while (map.size < size) {
            val key = random.nextInt()
            val stringSize = random.nextInt(1, 100)
            val value = List(stringSize) {
                random.nextInt(0x0000, 0xFFFF).toChar()
            }.joinToString("")
            map[key] = value
        }
        map
    }
