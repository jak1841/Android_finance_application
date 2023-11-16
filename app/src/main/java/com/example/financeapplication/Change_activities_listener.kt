package com.example.financeapplication

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity

class Change_activities_listener (private val targetActivity: Class<out Activity>) : View.OnClickListener {
    override fun onClick(view: View) {
        val intent = Intent(view.context, targetActivity)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        view.context.startActivity(intent)
    }
}