package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    interface Update {

        fun update(value: UiState)

    }

    interface Mutable: Update {

        fun save(bundleWrapper: BundleWrapper.Save)

        fun liveData(): LiveData<UiState>
    }

    class Base (private val liveData: SingleLiveEvent<UiState>) : Mutable {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            bundleWrapper.save(liveData.value!!)
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}