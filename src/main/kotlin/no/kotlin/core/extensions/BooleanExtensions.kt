package no.kotlin.core.extensions

fun Boolean.ifTrue(ifTrue: () -> Unit): Boolean {
    if (this) run(ifTrue)
    return this
}

fun Boolean.ifFalse(ifFalse: () -> Unit) {
    if (!this) run(ifFalse)
}

fun <T> Boolean.ifTrueOrElse(ifTrue: () -> T, ifFalse: () -> T): T {
    return if (this) kotlin.run(ifTrue) else kotlin.run(ifFalse)
}