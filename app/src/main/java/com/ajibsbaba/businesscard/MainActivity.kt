package com.ajibsbaba.businesscard

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.businesscard.ui.theme.Blue100
import com.ajibsbaba.businesscard.ui.theme.BusinessCardTheme
import com.ajibsbaba.businesscard.ui.theme.Purple800
import com.ajibsbaba.businesscard.ui.theme.Yellow200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Samuel Ajibade", color = Color.Black, fontWeight = FontWeight.ExtraBold, fontSize = 30.sp)
            Text(text = "Mobile Engineer", color = MaterialTheme.colors.onSurface)
            Text(text = "A developer concerned with making lives easier")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileImage() {
    Box(modifier = Modifier.padding(top = 12.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ajibsbaba),
            contentDescription = "Profile Image", modifier = Modifier.size(130.dp)
        )
    }
}


@Preview()
@Composable
fun PortfolioButton(ButtonText: String? = "Contact Me") {
    Button(modifier = Modifier
        .width(200.dp)
        .height(45.dp), colors = ButtonDefaults.buttonColors(
        backgroundColor = Blue100, contentColor = Color.White
        ),  shape = RoundedCornerShape(10.dp), onClick = { Log.d(TAG, "Create Projects Card")}) {
    Text(text = "$ButtonText", fontWeight = FontWeight.SemiBold)
    }
}



@Preview()
@Composable
fun ProjectCard(projectName: String? = "Acefood",
                projectDetails: String? = "An app that detects diseases in tomato plants") {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(140.dp), shape = RoundedCornerShape(corner = CornerSize(28.dp)), backgroundColor = Purple800) {
        Column(modifier = Modifier.padding(28.dp)) {
            Text(text = "$projectName", fontWeight = FontWeight.ExtraBold, fontSize = 24.sp, color = Color.Black)
            Text(text = "$projectDetails", fontWeight = FontWeight.Normal, color = Color.DarkGray)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()) {
            ProfileImage()
            BusinessCard()
            PortfolioButton()
            ProjectCard()
        }
    }
}