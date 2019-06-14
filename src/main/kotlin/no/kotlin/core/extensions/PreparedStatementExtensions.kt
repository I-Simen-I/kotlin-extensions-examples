package no.kotlin.core.extensions

import java.sql.Date
import java.sql.PreparedStatement
import java.sql.Types
import java.time.LocalDate

fun PreparedStatement.setNullableLong(parameterIndex: Int, x: Long?) =
        x?.let { setLong(parameterIndex, it) } ?: setNull(parameterIndex, Types.BIGINT)

fun PreparedStatement.setLocalDate(parameterIndex: Int, x: LocalDate?) = setDate(parameterIndex, x?.let(Date::valueOf))