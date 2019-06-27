package no.simensohol.kotlin.extensions.examples

fun Any?.isNull(): Boolean = this == null

fun Any?.isNotNull(): Boolean = isNull().not()