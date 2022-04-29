package me.nablon.singleeventlivedata

import androidx.lifecycle.Observer

/**
 * Observer that observes the SingleEventLiveData and resets the LiveData's value afterwards.
 */
open class SingleEventObserver<T : SingleEventAction>(
    private val triggerListener: SingleEventTriggerListener<T>
    ) : Observer<T> {

    private var singleLiveData: SingleEventLiveData<T>? = null

    fun setLiveData(liveData: SingleEventLiveData<T>) {
        this.singleLiveData = liveData
    }

    override fun onChanged(t: T?) {
        if (t == null) return
        triggerListener.onTriggered(t)
        singleLiveData?.reset()
    }
}
