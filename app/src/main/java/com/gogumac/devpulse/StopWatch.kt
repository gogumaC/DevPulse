package com.gogumac.devpulse

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class StopWatch() {

    private var isRunning: Boolean = false
    private var startTime: Long = 0
    private var pauseTime: Long = 0

    private lateinit var timerJob: Job

    private val _currentTimeFlow = MutableStateFlow<Long>(0)
    val currentTimeFlow: Flow<Long> get() = _currentTimeFlow

    fun start() {
        if (::timerJob.isInitialized) timerJob.cancel()
        isRunning = true
        if (isRunning) {
            startTime = System.currentTimeMillis() - pauseTime
            timerJob = CoroutineScope(Dispatchers.IO).launch {
                while (isRunning) {
                    val currentTime = System.currentTimeMillis() - startTime
                    _currentTimeFlow.value = currentTime
                    delay(1000)
                }
            }

        }
    }

    fun pause() {
        isRunning = false
        if (::timerJob.isInitialized) timerJob.cancel()
        pauseTime = System.currentTimeMillis() - startTime
    }

}