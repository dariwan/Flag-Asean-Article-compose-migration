package com.example.flagasean.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flagasean.HomeToAppBar
import com.example.flagasean.repository.CountryRepository
import com.example.flagasean.ui.profile.ProfileScreen
import com.example.flagasean.ui.theme.FlagAseanTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = HomeViewModel.ViewModelFactory(
            CountryRepository(),
        )
    ),

    navigateToProfile: () -> Unit,
    navigatetoDetail: (String) -> Unit,
) {
    val country by viewModel.country.collectAsState()

    Scaffold(
        topBar = {
            HomeToAppBar(
                action = {
                    navigateToProfile()
                }
            )
        },
        modifier = modifier
    ){
        paddingValue ->
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(
                    country,
                    key = {it.id}
                ){
                    CountryItem(
                        photoUrl = it.photoUrl,
//                        id = it.id,
                        name = it.name,
//                        description = it.description,
                        modifier = Modifier.clickable { navigatetoDetail(it.id) }
                    )
                }

            },  modifier = Modifier
                .padding(paddingValue))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FlagAseanTheme {
        HomeScreen(navigateToProfile = { }, navigatetoDetail = {})

    }
}