package com.example.walletappui.wallet_UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MedicalServices
import androidx.compose.material.icons.rounded.Payment
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappui.R
import com.example.walletappui.randomColor

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "Spending",
        color = MaterialTheme.colorScheme.onBackground,
        fontFamily = Font(R.font.playbold).toFontFamily(),
        fontSize = 25.sp,
    )
    Spacer(modifier = Modifier.height(16.dp))
    SpendingList(
        modifier = modifier
    )

}

@Composable
fun SpendingList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(spendingItems.size) {
            SpendingItem(spendingItem = spendingItems[it])
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun SpendingItem(modifier: Modifier = Modifier, spendingItem: SpendingItem) {
    ElevatedCard(
        modifier = modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(spendingItem.color.copy(alpha = 0.5f))
                .padding(20.dp)
        ) {
            Icon(
                imageVector = spendingItem.icon,
                contentDescription = spendingItem.name,
                tint = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = spendingItem.name,
                fontFamily = Font(R.font.rubikmedium).toFontFamily(),
                color = Color.Black.copy(alpha = 0.7f),
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "$" + spendingItem.amount.toString(),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = Font(R.font.rubiksemibold).toFontFamily()
            )
        }
    }
}

val spendingItems = listOf(
    SpendingItem(
        name = "Groceries",
        amount = 25.5f,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingCart
    ),
    SpendingItem(
        name = "Subscriptins",
        amount = 75.0f,
        color = randomColor(),
        icon = Icons.Rounded.Subscriptions
    ),
    SpendingItem(
        name = "Medical",
        amount = 120.0f,
        color = randomColor(),
        icon = Icons.Rounded.MedicalServices
    ),
    SpendingItem(
        name = "Payment",
        amount = 25.5f,
        color = randomColor(),
        icon = Icons.Rounded.Payment
    ),
    SpendingItem(
        name = "Utilities",
        amount = 75.0f,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingCart
    ),
    SpendingItem(
        name = "Subscriptins",
        amount = 120.0f,
        color = randomColor(),
        icon = Icons.Rounded.Subscriptions
    ),
    SpendingItem(
        name = "Groceries",
        amount = 25.5f,
        color = randomColor(),
        icon = Icons.Rounded.Payment
    ),
    SpendingItem(
        name = "Utilities",
        amount = 75.0f,
        color = randomColor(),
        icon = Icons.Rounded.Subscriptions
    ),
    SpendingItem(
        name = "Entertaient",
        amount = 120.0f,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingCart
    ),
    SpendingItem(
        name = "Groceries",
        amount = 25.5f,
        color = randomColor(),
        icon = Icons.Rounded.MedicalServices
    )
)
data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector

)