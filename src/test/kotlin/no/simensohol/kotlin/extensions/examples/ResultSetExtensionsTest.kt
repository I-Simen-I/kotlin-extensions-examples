package no.simensohol.kotlin.extensions.examples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import java.sql.Date
import java.sql.ResultSet
import java.time.LocalDate

private const val NULL_COLUMN = "null"
private const val NOT_NULL_COLUMN = "notNull"

@ExtendWith(MockitoExtension::class)
internal class ResultSetExtensionsTest {
    private val resultSetMock: ResultSet = mock(ResultSet::class.java)

    @Test
    fun `Test that getNullableLong returns the expected value`() {
        `when`(resultSetMock.getLong(NOT_NULL_COLUMN)).thenReturn(1L)
        `when`(resultSetMock.getLong(NULL_COLUMN)).thenReturn(0L)
        `when`(resultSetMock.wasNull()).thenReturn(false, true)

        val value = resultSetMock.getNullableLong(NOT_NULL_COLUMN)
        assertThat(value).isNotNull()
        assertThat(value!!).isEqualTo(1L)

        assertThat(resultSetMock.getNullableLong(NULL_COLUMN)).isNull()
    }

    @Test
    fun `Test that getLocalDate returns the expected value`() {
        val now = LocalDate.now()
        `when`(resultSetMock.getDate(NOT_NULL_COLUMN)).thenReturn(Date.valueOf(now))
        `when`(resultSetMock.getDate(NULL_COLUMN)).thenReturn(null)

        val value = resultSetMock.getLocalDate(NOT_NULL_COLUMN)
        assertThat(value).isNotNull()
        assertThat(value!!).isEqualTo(now)

        assertThat(resultSetMock.getLocalDate(NULL_COLUMN)).isNull()
    }

    @Test
    fun `Test that getEnum returns the expected value`() {
        `when`(resultSetMock.getString(NOT_NULL_COLUMN)).thenReturn("EN")
        `when`(resultSetMock.getString(NULL_COLUMN)).thenReturn(null)

        val value = resultSetMock.getEnum<TestEnum>(NOT_NULL_COLUMN)
        assertThat(value).isNotNull
        assertThat(value is TestEnum).isTrue()
        assertThat(value).isEqualTo(TestEnum.EN)

        assertThat(resultSetMock.getEnum<TestEnum>(NULL_COLUMN)).isNull()
    }

    private enum class TestEnum {
        EN
    }
}