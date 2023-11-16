package com.example.financeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        initButtonListeners()
    }

    private fun initButtonListeners() {
        val insightsButton: ImageButton = findViewById(R.id.insights_button)
        val homeButton: ImageButton = findViewById(R.id.home_button)
        val historyButton: ImageButton = findViewById(R.id.history_button)

        insightsButton.setOnClickListener(Change_activities_listener(InsightsActivity::class.java))
        homeButton.setOnClickListener(Change_activities_listener(HomeActivity::class.java))
        historyButton.setOnClickListener(Change_activities_listener(HistoryActivity::class.java))


    }

}