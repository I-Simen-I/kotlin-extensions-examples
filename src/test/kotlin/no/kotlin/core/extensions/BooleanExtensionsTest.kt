package no.kotlin.core.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BooleanExtensionsTest {

    @Test
    fun `Test that ifTrue executes the given code if Boolean is true`() {
        var aNumber = 4

        true
                .ifTrue { aNumber++ }
                .ifFalse { aNumber-- }

        assertThat(aNumber).isEqualTo(5)
    }

    @Test
    fun `Test that ifFalse executes the given code if Boolean is false`() {
        var aNumber = 4

        false
                .ifTrue { aNumber++ }
                .ifFalse { aNumber-- }

        assertThat(aNumber).isEqualTo(3)
    }

    @Test
    fun `Test that ifTrueOrElse returns the expected values`() {
        assertThat(true.ifTrueOrElse({ 1 + 1 }, { 2 + 2 })).isEqualTo(2)
        assertThat(false.ifTrueOrElse({ 1 + 1 }, { 2 + 2 })).isEqualTo(4)
    }
}