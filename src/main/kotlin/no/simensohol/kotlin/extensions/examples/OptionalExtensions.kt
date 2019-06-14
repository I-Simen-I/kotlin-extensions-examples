package no.simensohol.kotlin.extensions.examples

import java.util.Optional

fun <T, R> Optional<R>.ifPresentOrElseReturn(ifPresent: () -> T, ifNotPresent: () -> T): T =
        if (this.isPresent) run(ifPresent) else run(ifNotPresent)