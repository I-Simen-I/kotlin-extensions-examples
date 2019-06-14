package no.simensohol.kotlin.extensions.examples

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.Types
import java.time.LocalDate

private const val PARAMETER_INDEX = 1;

@ExtendWith(MockitoExtension::class)
internal class PreparedStatementExtensionsTest {
    private val preparedStatementMock: PreparedStatement = Mockito.mock(PreparedStatement::class.java)

    @Test
    fun `Test that setNullableLong sets the correct value`() {
        preparedStatementMock.setNullableLong(PARAMETER_INDEX, 1L)
        Mockito.verify(preparedStatementMock, Mockito.times(1)).setLong(PARAMETER_INDEX, 1L)

        preparedStatementMock.setNullableLong(PARAMETER_INDEX, null)
        Mockito.verify(preparedStatementMock, Mockito.times(1)).setNull(PARAMETER_INDEX, Types.BIGINT)
    }

    @Test
    fun `Test that setLocalDate sets the correct value`() {
        val now = LocalDate.now()

        preparedStatementMock.setLocalDate(PARAMETER_INDEX, now)
        Mockito.verify(preparedStatementMock, Mockito.times(1)).setDate(PARAMETER_INDEX, Date.valueOf(now))

        preparedStatementMock.setLocalDate(PARAMETER_INDEX, null)
        Mockito.verify(preparedStatementMock, Mockito.times(1)).setDate(PARAMETER_INDEX, null)
    }
}