package me.nablon.singleeventlivedata

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *  Based on LiveData class, but modified to reset the value of livedata after the value
 *  is processed, so that resuming ViewModel does not re-trigger the observer.
 */
class SingleEventLiveData<T : SingleEventAction> : LiveData<T>() {

    @MainThread
    fun observe(owner: LifecycleOwner, observer: SingleEventObserver<T>) {
        observer.setLiveData(this)
        super.observe(owner, observer)
    }

    @MainThread
    fun observeForever(observer: SingleEventObserver<T>) {
        observer.setLiveData(this)
        super.observeForever(observer)
    }

    @WorkerThread
    override fun postValue(value: T) {
        if (value == getValue()) return
        super.postValue(value)
    }

    @MainThread
    override fun setValue(value: T) {
        if (value == getValue()) return
        super.setValue(value)
    }

    fun reset() {
        super.setValue(null)
    }
}