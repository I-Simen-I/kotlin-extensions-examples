package no.simensohol.kotlin.extensions.examples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnyExtensionsTest {
    @Test
    fun `Test that isNull() is true`() {
        val nullString: String? = null
        val nullInt: Int? = null
        val nullList: List<Any>? = null

        assertThat(null.isNull()).isTrue()
        assertThat(nullString.isNull()).isTrue()
        assertThat(nullInt.isNull()).isTrue()
        assertThat(nullList.isNull()).isTrue()
    }

    @Test
    fun `Test that isNull() is false`() {
        assertThat("".isNull()).isFalse()
        assertThat(1.isNull()).isFalse()
        assertThat(listOf("", "").isNull()).isFalse()
    }

    @Test
    fun `Test that isNotNull() is true`() {
        assertThat("".isNotNull()).isTrue()
        assertThat(1.isNotNull()).isTrue()
        assertThat(listOf("", "").isNotNull()).isTrue()
    }

    @Test
    fun `Test that isNotNull() is false`() {
        val nullString: String? = null
        val nullInt: Int? = null
        val nullList: List<Any>? = null

        assertThat(null.isNotNull()).isFalse()
        assertThat(nullString.isNotNull()).isFalse()
        assertThat(nullInt.isNotNull()).isFalse()
        assertThat(nullList.isNotNull()).isFalse()
    }
}