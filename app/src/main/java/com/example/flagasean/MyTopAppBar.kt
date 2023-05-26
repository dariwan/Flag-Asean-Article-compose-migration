package com.example.flagasean

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTopAppBar(
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = {
            Text(
                text = "Country App",
                style = MaterialTheme.typography.h1,
                fontSize = 30.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = {action()}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colors.onSurface
                )

            }
        },
        modifier = modifier
    )
}