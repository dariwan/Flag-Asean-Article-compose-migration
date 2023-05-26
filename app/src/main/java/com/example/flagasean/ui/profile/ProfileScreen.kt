package com.example.flagasean.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flagasean.BannerProfile
import com.example.flagasean.MyTopAppBar
import com.example.flagasean.ui.detail.DetailPage
import com.example.flagasean.ui.theme.FlagAseanTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            MyTopAppBar(
                action = {
                    navigateUp()
                }
            )
        }
    ) {paddingValue ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValue)
                .verticalScroll(rememberScrollState())
        ) {
            BannerProfile()
            Spacer(modifier = Modifier.padding(24.dp))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CountryAppPreview() {
    FlagAseanTheme {
        ProfileScreen {

        }

    }
}