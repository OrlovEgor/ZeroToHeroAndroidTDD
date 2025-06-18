package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

interface Repository {

  suspend fun waitTimes(time: Int)

    class Base(): Repository {

        override suspend fun waitTimes(time: Int) {
            delay(time.toLong())
        }
    }
}