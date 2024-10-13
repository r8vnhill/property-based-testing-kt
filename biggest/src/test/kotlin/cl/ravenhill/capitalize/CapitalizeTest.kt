package cl.ravenhill.capitalize

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.Codepoint
import io.kotest.property.arbitrary.az
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class CapitalizeTest : FreeSpec({
    "A String" - {
        "when capitalizing its words" - {
            "should not change the number of words" {
                checkAll(Arb.string(1..100, Codepoint.az())) { string ->
                    countWords(string) shouldBe countWords(capitalizeWords(string))
                }
            }

            "should be idempotent" {
                checkAll(Arb.string(1..100, Codepoint.az())) { string ->
                    capitalizeWords(capitalizeWords(string)) shouldBe capitalizeWords(string)
                }
            }

            "should contain only words with the first letter capitalized" {
                checkAll(Arb.string(1..100, Codepoint.az())) { string ->
                    for (word in capitalizeWords(string).split(" ")) {
                        word.first().isUpperCase().shouldBeTrue()
                        for (i in 1..<word.length) {
                            word[i].isLowerCase().shouldBeTrue()
                        }
                    }
                }
            }
        }
    }
})

fun capitalizeWords(string: String): String {
    TODO("Not yet implemented")
}

private fun countWords(string: String) =
    string.split(" ")
        .count { it.isNotBlank() }
