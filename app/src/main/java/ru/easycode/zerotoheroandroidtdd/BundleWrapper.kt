package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle



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
            bundle.putParcelable("Key", uiState)
        }

        override fun restore(): UiState {
            val result = bundle.getParcelable<UiState>("Key")
            return result!!
        }
    }


}









