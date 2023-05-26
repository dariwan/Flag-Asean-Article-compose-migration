package com.example.flagasean

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeToAppBar(
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = {
//            Text(
//                text = stringResource(id = R.string.app_name),
//                style = MaterialTheme.typography.h1,
//                fontSize = 30.sp
//            )
        },
        actions = {
            IconButton(onClick = {action()}) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "About Me",
                    tint = MaterialTheme.colors.onSurface
                )
            }
        },
        modifier = modifier
    )
}