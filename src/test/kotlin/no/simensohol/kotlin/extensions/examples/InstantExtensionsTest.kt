package no.simensohol.kotlin.extensions.examples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.Month

private val INSTANT_2019_06_18 = Timestamp.valueOf(LocalDateTime.of(2019, Month.JUNE, 18, 13, 37, 13, 37)).toInstant()

private val INSTANT_2019_06_21 = Timestamp.valueOf(LocalDateTime.of(2019, Month.JUNE, 21, 13, 37, 13, 37)).toInstant()

internal class InstantExtensionsTest {

    @Test
    fun `Test that plusDays() returns the expected instant`() {
        assertThat(INSTANT_2019_06_18.plusDays(3)).isEqualTo(INSTANT_2019_06_21)
    }

    @Test
    fun `Test that minusDays() returns the expected instant`() {
        assertThat(INSTANT_2019_06_21.minusDays(3)).isEqualTo(INSTANT_2019_06_18)
    }
}