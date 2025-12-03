package hu.zsut.memofy.core.events

import kotlinx.coroutines.flow.SharedFlow

interface EventEmitter {
    val toastEvent: SharedFlow<Unit>
}