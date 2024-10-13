package cl.ravenhill.reverse

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

class ReverseTest : FreeSpec({
    "Given two integer lists" - {
        "when reversing the concatenation of the lists" - {
            ("should return the reverse of the second list" +
                    "concatenated with the reverse of the first list") {
                checkAll(
                    Arb.list(Arb.int()),
                    Arb.list(Arb.int())
                ) { list1, list2 ->
                    reverse(list1 + list2) shouldBe
                            (reverse(list2) + reverse(list1))
                }
            }
        }
    }
})
