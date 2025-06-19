package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper: ProvideLiveData {

    fun save(bundleWrapper: BundleWrapper.Save)

    fun update(value: UiState)


    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            TODO("Not yet implemented")
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

         override fun liveData(): LiveData<UiState> {
            return liveData
        }

    }

}
interface ProvideLiveData {
    fun liveData(): LiveData<UiState>
}