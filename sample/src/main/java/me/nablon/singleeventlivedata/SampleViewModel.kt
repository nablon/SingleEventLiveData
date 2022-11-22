package me.nablon.singleeventlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {

    val navFlowAction = SingleEventLiveData<NavFlowEventAction>()

    fun openFirstPage() {
        navFlowAction.setValue(OpenFirstActivityAction)
    }

    fun openSecondPage() {
        navFlowAction.setValue(OpenSecondActivityAction)
    }
}