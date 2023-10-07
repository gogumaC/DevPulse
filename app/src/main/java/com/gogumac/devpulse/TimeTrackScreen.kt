package com.gogumac.devpulse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogumac.devpulse.ui.theme.DevPulseTheme

@Composable
fun TimeTrackScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        TimeIndicator()
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(50.dp),
            onClick = { /*TODO*/ },
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Default.PlayArrow,
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