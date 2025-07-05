package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private val liveData = MutableLiveData<UiState>()

    fun load() {
        scope.launch {
            liveData.value = UiState.ShowProgress
            repository.load().show(updateLiveData = liveDataWrapper)
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        bundleWrapper.save(liveDataWrapper.liveData().value!!)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        bundleWrapper.restore()
    }
}