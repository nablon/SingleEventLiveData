package me.nablon.singleeventlivedata

/**
 * Actions associated with Navigation flows.
 */
sealed class NavFlowEventAction : me.nablon.singleeventlivedata.SingleEventAction()

object OpenFirstActivityAction : NavFlowEventAction()

object OpenSecondActivityAction : NavFlowEventAction()