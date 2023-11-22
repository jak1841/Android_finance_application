package com.example.financeapplication
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }



    }

    private fun initButtonListeners() {
        val insightsButton:ImageButton = findViewById(R.id.insights_button)
        val homeButton:ImageButton = findViewById(R.id.home_button)
        val historyButton: ImageButton = findViewById(R.id.history_button)

        insightsButton.setOnClickListener(Change_activities_listener(InsightsActivity::class.java))
        homeButton.setOnClickListener(Change_activities_listener(HomeActivity::class.java))
        historyButton.setOnClickListener(Change_activities_listener(HistoryActivity::class.java))


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
        ) {

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
            bottomButton(graphIcon)
            bottomButton(homeImage)
            bottomButton(historyImage)




        }
    }

    @Composable
    fun bottomButton (image:Painter) {

        Surface (
            modifier = Modifier
                .size(60.dp),
            shape = RoundedCornerShape(50.dp),
            color = Color.Transparent
        ) {
            IconButton(
                onClick = { /* Handle button click */ },
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