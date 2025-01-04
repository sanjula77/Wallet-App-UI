package com.example.walletappui.wallet_UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappui.R

@Composable
fun CardSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Yellow, Color.Green)
                    )
                )
        )
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            CardContent(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color.DarkGray,
                        MaterialTheme.colorScheme.error
                    )
                )
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.world),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background.copy(alpha = 0.1f),
            modifier = Modifier
                .fillMaxSize()
                .offset(140.dp, 90.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "My Balance",
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                fontFamily = Font(R.font.playregular).toFontFamily(),
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "$12.000",
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = Font(R.font.playbold).toFontFamily(),
                fontSize = 35.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
            .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "* * * * 6524",
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = Font(R.font.playregular).toFontFamily(),
                fontSize = 23.sp,
                modifier = Modifier.padding(bottom = 18.dp, start = 22.dp)
            )

                Icon(
                    painter = painterResource(R.drawable.ic_visa),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .width(130.dp)
                        .padding(end = 22.dp, bottom = 5.dp)
                )

        }
    }
}
