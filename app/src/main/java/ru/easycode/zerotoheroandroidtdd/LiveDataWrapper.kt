package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper: ProvideLiveData {

    fun update(value: UiState)

    class Base(
        private val data: MutableLiveData<UiState> = MutableLiveData<UiState>()
    ): LiveDataWrapper {

        override fun update(value: UiState) {
            data.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return data
        }
    }
}

interface ProvideLiveData {
    fun liveData(): LiveData<UiState>
}