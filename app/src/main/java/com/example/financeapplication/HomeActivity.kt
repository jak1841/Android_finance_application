package com.example.financeapplication
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }





    @Composable
    fun MyApp() {
        // Compose UI hierarchy
        Column (
            modifier = Modifier
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
                ) {
            TopTaskBar()
            MiddleScreen()
            BottomBar()
        }

    }

    @Composable
    fun TopTaskBar () {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF90EE90)
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
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            addDailyLimitButton()
            addExpenseButton()
            addIncomeButton()
        }
    }

    @Composable
    fun addExpenseButton () {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF90EE90)
            )

        ) {
            Text(
                text = "Add Expense",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }

    }

    @Composable
    fun addIncomeButton () {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF90EE90)
            )

        ) {
            Text(
                text = "Add Income",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }

    }

    @Composable
    fun addDailyLimitButton () {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF90EE90)
            )

        ) {
            Text(
                text = "Daily Limit",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                ),
            )
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
    fun bottomButton (image:Painter, listener: Change_activities_listener) {

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





}