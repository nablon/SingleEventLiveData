package me.nablon.singleeventlivedata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class SampleActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(SampleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_activity)
        val firstButton = findViewById<Button>(R.id.first_page_button)
        val secondButton = findViewById<Button>(R.id.second_page_button)
        firstButton.setOnClickListener {
            viewModel.openFirstPage()
        }
        secondButton.setOnClickListener {
            viewModel.openSecondPage()
        }

        viewModel.navFlowAction.observe(this) {
            handleNavFlow(it)
        }
    }

    private fun handleNavFlow(action: NavFlowEventAction) {
        when(action) {
            is OpenFirstActivityAction -> {
                val intent = Intent(this@SampleActivity, FirstActivity::class.java)
                startActivity(intent)
            }
            is OpenSecondActivityAction -> {
                val intent = Intent(this@SampleActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}