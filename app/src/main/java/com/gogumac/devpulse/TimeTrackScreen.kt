package com.gogumac.devpulse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogumac.devpulse.ui.theme.DevPulseTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun TimeTrackScreen(modifier: Modifier = Modifier) {

    var isActivated by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        TimeIndicator()
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(50.dp),
            onClick = { isActivated = !isActivated },
        ) {
            val icon = if (isActivated) Icons.Default.Done else Icons.Default.PlayArrow
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = icon,
                contentDescription = null
            )
        }
    }
}

@Composable
fun TimeIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            progress = 0.3f,
            strokeWidth = 20.dp,
        )
        Text(
            modifier = Modifier,
            text = "00:00",
            fontSize = 42.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimeTrackScreenPreview() {
    DevPulseTheme {
        TimeTrackScreen()
    }
}