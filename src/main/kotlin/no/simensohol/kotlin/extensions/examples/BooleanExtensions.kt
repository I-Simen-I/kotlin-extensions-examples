package no.simensohol.kotlin.extensions.examples

fun Boolean.ifTrue(ifTrue: () -> Unit): Boolean {
    if (this) run(ifTrue)
    return this
}

fun Boolean.ifFalse(ifFalse: () -> Unit) {
    if (!this) run(ifFalse)
}

fun <T> Boolean.ifTrueOrElse(ifTrue: () -> T, ifFalse: () -> T): T =
        if (this) run(ifTrue) else run(ifFalse)