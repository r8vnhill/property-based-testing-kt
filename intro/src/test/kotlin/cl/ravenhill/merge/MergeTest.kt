package cl.ravenhill.merge

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class MergeTest : FreeSpec({
    "Merging two lists" - {
        "should return a list with all elements sorted" - {
            withData(
                MergeTestCase(listOf(), listOf(), listOf()),
                MergeTestCase(listOf(1), listOf(), listOf(1)),
                MergeTestCase(listOf(), listOf(1), listOf(1)),
                MergeTestCase(listOf(1), listOf(1), listOf(1, 1)),
                MergeTestCase(listOf(1, 2), listOf(1), listOf(1, 1, 2)),
                MergeTestCase(listOf(1), listOf(1, 2), listOf(1, 1, 2)),
                MergeTestCase(listOf(1, 3), listOf(2, 4), listOf(1, 2, 3, 4)),
                MergeTestCase(listOf(1, 2, 3), listOf(4, 5, 6), listOf(1, 2, 3, 4, 5, 6)),
            ) { (list1, list2, expected) ->
                merge(list1, list2) shouldBe expected
            }
        }
    }
})

data class MergeTestCase(
    val list1: List<Int>,
    val list2: List<Int>,
    val expected: List<Int>
)
