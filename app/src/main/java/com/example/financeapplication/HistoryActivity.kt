package com.example.financeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_history)
//        initButtonListeners()
//        initDataTable()

        setContent{
            Screen()
        }


    }


    @Composable
    fun Screen() {
        Column (
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar()
            MiddleScreen()
            BottomBar()
        }
    }

    @Composable
    fun TopBar() {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFa9a9a9)
                )
                .height(100.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(
                text = "Home",
                fontSize = 40.sp,
                modifier = Modifier.weight(1f)
            )
        }
    }

    @Composable
    fun MiddleScreen () {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(470.dp)
                .background(
                    color = Color(0xFF9ac0cd)
                ),
        ) {
            DataTable()
        }
    }

    @Composable
    fun BottomBar() {

        val graphIcon = painterResource(id = R.drawable.burghundy)
        val homeImage = painterResource(id = R.drawable.home_icon)
        val historyImage = painterResource(id = R.drawable.history_icon)

        Row (
            modifier = Modifier
                .background(
                    color = Color.Black
                )
                .fillMaxWidth()
                .fillMaxHeight()
            ,

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            bottomButton(graphIcon, Change_activities_listener(InsightsActivity::class.java))
            bottomButton(homeImage, Change_activities_listener(HomeActivity::class.java))
            bottomButton(historyImage, Change_activities_listener(HistoryActivity::class.java))




        }
    }

    @Composable
    fun bottomButton (image: Painter, listener: Change_activities_listener) {

        Surface (
            modifier = Modifier
                .size(60.dp),
            shape = RoundedCornerShape(50.dp),
            color = Color.Transparent
        ) {
            IconButton(
                onClick = {listener.click(this)},
                modifier = Modifier
                    .background(
                        color = Color(0xFF9ac0cd )
                    )
            ) {
                Image(
                    painter = image,
                    contentDescription = null, // Content description can be null for decorative images
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }


    private fun initButtonListeners() {
        val insightsButton: ImageButton = findViewById(R.id.insights_button)
        val homeButton: ImageButton = findViewById(R.id.home_button)
        val historyButton: ImageButton = findViewById(R.id.history_button)

        insightsButton.setOnClickListener(Change_activities_listener(InsightsActivity::class.java))
        homeButton.setOnClickListener(Change_activities_listener(HomeActivity::class.java))
        historyButton.setOnClickListener(Change_activities_listener(HistoryActivity::class.java))
    }


    @Composable
    fun DataTable() {
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
        LazyColumn {
            items(data) { item ->
                itemCard(item)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    // This will be the row inside the datatable
    @Composable
    fun itemCard(item:Triple<String, String, String>){
        val textSize = 21
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = item.first,
                style = TextStyle(
                    fontSize = textSize.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .weight(.25f)
                    .padding(8.dp)
            )

            Text(
                text = item.second,
                style = TextStyle(
                    fontSize = textSize.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .weight(.35f)
                    .padding(8.dp)
            )

            Text(
                text = item.third,
                style = TextStyle(
                    fontSize = textSize.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .weight(.4f)
                    .padding(8.dp)
            )
        }

    }




}