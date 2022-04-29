package me.nablon.singleeventlivedata

/**
 * Listener that is triggered when the value of LiveData changes.
 */
fun interface SingleEventTriggerListener<T : SingleEventAction> {
    fun onTriggered(action: T)
}