package cl.ravenhill.strings

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class StringConcatenationTest : FreeSpec({
    "String concatenation" - {
        "should result in a string with the length of the sum of the lengths of the input strings" {
            checkAll(Arb.string(), Arb.string()) { s1, s2 ->
                (s1 + s2).length shouldBe s1.length + s2.length
            }
        }

        "should follow monoid laws" - {
            "left identity" {
                checkAll(Arb.string()) { s ->
                    ("" + s) shouldBe s
                }
            }

            "right identity" {
                checkAll(Arb.string()) { s ->
                    (s + "") shouldBe s
                }
            }

            "associativity" {
                checkAll(Arb.string(), Arb.string(), Arb.string()) { s1, s2, s3 ->
                    ((s1 + s2) + s3) shouldBe (s1 + (s2 + s3))
                }
            }
        }
    }
})
