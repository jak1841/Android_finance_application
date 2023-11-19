package com.example.financeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        initButtonListeners()
        initDataTable()
    }

    private fun initButtonListeners() {
        val insightsButton: ImageButton = findViewById(R.id.insights_button)
        val homeButton: ImageButton = findViewById(R.id.home_button)
        val historyButton: ImageButton = findViewById(R.id.history_button)

        insightsButton.setOnClickListener(Change_activities_listener(InsightsActivity::class.java))
        homeButton.setOnClickListener(Change_activities_listener(HomeActivity::class.java))
        historyButton.setOnClickListener(Change_activities_listener(HistoryActivity::class.java))
    }

    private fun initDataTable () {
        val data = listOf(
            Triple("-$10", "Fast Food", "2023-10-15"),
            Triple("+$500", "Bonus", "2023-10-15"),
            Triple("-$250", "Utilities", "2023-10-16"),
            Triple("-$300", "Groceries", "2023-10-16"),
            Triple("-$50", "Dinner", "2023-10-16"),
            Triple("-$120", "Groceries", "2023-10-17"),
            Triple("-$20", "Uber", "2023-10-17"),
            Triple("-$300", "Groceries", "2023-10-16"),
            Triple("-$50", "Dinner", "2023-10-16"),
            Triple("-$120", "Groceries", "2023-10-17"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FinanceAdapter(data)
    }

}