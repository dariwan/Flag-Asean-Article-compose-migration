package com.example.flagasean.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.flagasean.CountryApp
import com.example.flagasean.ui.theme.FlagAseanTheme

@Composable
fun CountryItem(
    photoUrl: String,
    name: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .width(100.dp)
                    .height(90.dp))

            Spacer(modifier = Modifier.padding(start = 4.dp))
            Box(modifier = Modifier.weight(1f)){

                Column(modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .align(Alignment.Center)
                ) {
                    Text(text = name.uppercase(),
                        style = MaterialTheme.typography.h5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth())
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }

        }
        Spacer(modifier = Modifier.padding(6.dp))
        Divider(color = MaterialTheme.colors.onBackground, thickness = 0.5.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun CountryAppPreview() {
    FlagAseanTheme {
        CountryItem("", "Indonesia",  )

    }
}