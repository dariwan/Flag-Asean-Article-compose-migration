package com.example.flagasean.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.flagasean.MyTopAppBar
import com.example.flagasean.repository.CountryRepository
import com.example.flagasean.ui.theme.FlagAseanTheme


@Composable
fun DetailPage(
    modifier: Modifier = Modifier,
    idCountry: String,
    navigateUp: () -> Unit,
    detailViewModel: DetailViewModel = viewModel(
        factory = DetailViewModel.ViewModelFactory(
            CountryRepository()
        )
    )
) {
    val countryData by detailViewModel.getCountryData(idCountry).collectAsState()

    Scaffold(
        topBar = {
            MyTopAppBar(
                action = {
                    navigateUp()
                })
        }
    ) {paddingValue ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValue)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = countryData.photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )
            Spacer(modifier = Modifier.padding(14.dp))
            Text(
                text = countryData.name,
                style = MaterialTheme.typography.h2,
                fontSize = 30.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Divider(
                color = MaterialTheme.colors.onBackground,
                thickness = 1.dp
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = countryData.description,
                lineHeight = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .alpha(0.7f)
            )
            Spacer(modifier = Modifier.padding(16.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CountryAppPreview() {
    FlagAseanTheme {
        DetailPage(idCountry = "01", navigateUp = { })
    }
}