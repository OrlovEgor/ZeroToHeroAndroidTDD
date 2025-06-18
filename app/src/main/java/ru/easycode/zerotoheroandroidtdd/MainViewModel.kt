package ru.easycode.zerotoheroandroidtdd


import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import java.util.logging.Handler

class MainViewModel : ViewModel() {
    val repo = Repository.Base()
    val state = MutableLiveData<UiState>()

    fun load() {

        viewModelScope.launch {
            state.postValue(UiState.ShowProgress())
            repo.waitTimes(3500)
            state.postValue(UiState.ShowData())
        }


    }
}