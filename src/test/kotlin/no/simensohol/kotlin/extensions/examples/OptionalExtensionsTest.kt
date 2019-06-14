package no.simensohol.kotlin.extensions.examples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Optional

internal class OptionalExtensionsTest {

    @Test
    fun `Test that ifPresentOrElseReturn returns the expected values`() {
        assertThat(Optional.of("Present String").ifPresentOrElseReturn({ 1 + 1 }, { 2 + 2 })).isEqualTo(2)
        assertThat(Optional.ofNullable(null).ifPresentOrElseReturn({ 1 + 1 }, { 2 + 2 })).isEqualTo(4)
    }
}