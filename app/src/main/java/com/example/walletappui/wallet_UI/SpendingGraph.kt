package com.example.walletappui.wallet_UI

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.walletappui.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlin.random.Random
import androidx.compose.ui.graphics.toArgb

@Composable
fun SpendingGraph(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Spending summary",
            fontFamily = Font(R.font.playbold).toFontFamily(),
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Chart(modifier = Modifier.fillMaxWidth().height(300.dp))
    }
}

@Composable
fun Chart(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            BarChart(context).apply {
                description.isEnabled = false // Disable chart description
                setFitBars(true) // Fit bars to the chart width
            }
        },
        modifier = modifier,
        update = { barChart ->
            // Update BarChart with data
            val entries = spendingByDay.mapIndexed { index, data ->
                BarEntry(index.toFloat(), data.value)
            }

            val dataSet = BarDataSet(entries, "Spending Summary").apply {
                colors = spendingByDay.map { it.color.toArgb() }
                valueTextColor = Color.Black.toArgb()
                valueTextSize = 12f
            }

            barChart.data = BarData(dataSet)
            barChart.invalidate() // Refresh chart with new data
        }
    )
}

// Spending data
val spendingByDay = listOf(
    BarChartDate(label = "Dec 1", value = 400f, color = randomColor()),
    BarChartDate(label = "Dec 2", value = 250f, color = randomColor()),
    BarChartDate(label = "Dec 3", value = 300f, color = randomColor()),
    BarChartDate(label = "Dec 4", value = 500f, color = randomColor()),
    BarChartDate(label = "Dec 5", value = 350f, color = randomColor())
)
data class BarChartDate(
    val label: String,
    val value: Float,
    val color: Color
)
fun randomColor(): Color {
    val random = Random.Default
    return Color(
        red = random.nextInt(256),
        green = random.nextInt(256),
        blue = random.nextInt(256),
        alpha = 255
    )
}