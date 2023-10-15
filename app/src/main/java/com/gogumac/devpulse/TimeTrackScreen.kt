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
import androidx.compose.runtime.LaunchedEffect
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
fun TimeTrackScreen(
    modifier: Modifier = Modifier,
    stopWatch: StopWatch = remember { StopWatch() }
) {

    var isRunning by remember { mutableStateOf(false) }
    var currentTime by remember { mutableStateOf(0L) }

    LaunchedEffect(Unit) {
        stopWatch.currentTimeFlow.collect {
            currentTime = it / 1000
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        TimeIndicator(currentTime)
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(50.dp),
            onClick = {
                isRunning = !isRunning
                if (isRunning) stopWatch.start() else stopWatch.pause()
            },
        ) {
            val icon = if (isRunning) Icons.Default.Done else Icons.Default.PlayArrow
            Icon(
                modifier = Modifier.fillMaxSize(), imageVector = icon, contentDescription = null
            )
        }
    }
}

@Composable
fun TimeIndicator(time: Long, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            progress = time / (60f),
            strokeWidth = 20.dp,
        )
        Text(
            modifier = Modifier,
            text = time.toString(),
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