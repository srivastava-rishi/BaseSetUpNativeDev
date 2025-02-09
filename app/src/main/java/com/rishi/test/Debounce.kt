package com.rishi.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/*
Q1.
Create a Kotlin function that takes another function as an argument and debounces it.
The function being debounced should only execute after a specified delay has passed
since its last invocation ?
 */
val scope = CoroutineScope(Dispatchers.IO)

fun debounce(
    onClick: () -> Unit,
    timeInMillis: Long = 2000L
) {
    if (scope.isActive) return
    scope.launch {
        delay(timeInMillis)
        onClick()
    }
}


// Q2. How will you resume a suspend function? Can you write a code snippet for this?

interface ApiClientService {
    suspend fun fetchSomething()
}

class ApiClass : ApiClientService {
    override suspend fun fetchSomething() {
        delay(4000)
    }

}

fun resumeOrStartAboveSuspendableFunction() {
    CoroutineScope(Dispatchers.IO).launch {
        /*
        here I am executing that suspendable function
         */
        ApiClass().fetchSomething()
    }
}