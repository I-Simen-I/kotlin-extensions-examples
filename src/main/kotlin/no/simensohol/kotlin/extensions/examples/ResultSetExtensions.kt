package no.simensohol.kotlin.extensions.examples

import java.sql.ResultSet
import java.time.LocalDate

fun ResultSet.getNullableLong(columnLabel: String): Long? = getLong(columnLabel).let { if (wasNull()) null else it }

fun ResultSet.getLocalDate(columnLabel: String): LocalDate? = getDate(columnLabel)?.toLocalDate()

inline fun <reified T : Enum<T>> ResultSet.getEnum(columnLabel: String): T? =
        getString(columnLabel)?.let { enumValueOf<T>(it) }