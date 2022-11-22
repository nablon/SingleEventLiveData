package me.nablon.singleeventlivedata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "First activity opened")
    }

    companion object {
        private val TAG = SecondActivity::class.simpleName
    }
}