package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    class Base(
        private val step: Int,
        private val max:Int,
        private val min: Int
    ): Count {

        init {

        }

        override fun initial(number: String): UiState {
            return UiState.Base(number)
        }

        override fun increment(number: String): UiState {
            TODO("Not yet implemented")
        }

        override fun decrement(number: String): UiState {
            TODO("Not yet implemented")
        }
    }

}