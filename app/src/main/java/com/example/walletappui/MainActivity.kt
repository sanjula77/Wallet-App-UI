package com.example.walletappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walletappui.ui.theme.WalletAppUITheme
import com.example.walletappui.wallet_UI.ActionSection
import com.example.walletappui.wallet_UI.CardSection
import com.example.walletappui.wallet_UI.SpendingSection
import com.example.walletappui.wallet_UI.TopBar
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletAppUITheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopBar(
                            modifier = Modifier.fillMaxWidth(),
                            scrollBehavior = scrollBehavior
                        )
                    }
                ) { paddingvalues ->
                    MainScreen(
                        modifier = Modifier.padding(paddingvalues)
                            .fillMaxSize()
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            CardSection(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))
            ActionSection(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))
            SpendingSection(modifier= Modifier.fillMaxWidth())
        }
    }

}

fun randomColor(minBrightness: Int = 50): Color {
    val random = Random.Default
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)
    return Color(red, green, blue, minBrightness)
}