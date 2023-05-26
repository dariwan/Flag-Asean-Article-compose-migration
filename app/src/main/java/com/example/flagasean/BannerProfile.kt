package com.example.flagasean

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flagasean.ui.home.CountryItem
import com.example.flagasean.ui.theme.FlagAseanTheme

@Composable
fun BannerProfile(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "Back",
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )

            Spacer(modifier = Modifier.padding(18.dp))
            Text(
                text = "Dariwan",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "dariwan1607@gmail.com",
                color = Color.Black,
            )

        }

    }
}
