package no.simensohol.kotlin.extensions.examples

import java.time.Instant
import java.time.temporal.ChronoUnit

fun Instant.plusDays(numberOfDaysToAdd: Long): Instant = this.plus(numberOfDaysToAdd, ChronoUnit.DAYS)

fun Instant.minusDays(numberOfDaysToSubtract: Long): Instant = this.minus(numberOfDaysToSubtract, ChronoUnit.DAYS)