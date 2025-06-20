package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi


interface BundleWrapper {

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    interface Mutable : Save, Restore {

    }

    class Base(private val bundle: Bundle) : Mutable {
        override fun save(uiState: UiState) {
            bundle.putParcelable(KEY, uiState)
        }

        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        override fun restore(): UiState {
            val result = bundle.getParcelable<UiState>(KEY)
            Log.d("123", "${result.toString()}")
            return result!!
        }
    }

   companion object Key {
        const val KEY = "Key"
    }


}









