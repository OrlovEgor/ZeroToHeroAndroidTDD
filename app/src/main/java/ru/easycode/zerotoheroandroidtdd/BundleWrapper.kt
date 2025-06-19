package ru.easycode.zerotoheroandroidtdd

interface BundleWrapper {

    fun save(uiState: UiState)

    fun restore(): UiState

    class Base(): BundleWrapper {
        override fun save(uiState: UiState) {
            TODO("Not yet implemented")
        }

        override fun restore(): UiState {
            TODO("Not yet implemented")
        }

    }
}