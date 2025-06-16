package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    class Base(
        private val step: Int,
        private val max: Int,
        private val min: Int
    ) : Count {

        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")
            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")
            if (max < step)
                throw IllegalStateException("max should be more than step")
            if (max < min)
                throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            val digits = number.toInt()
            return if (digits > min && digits > step)
                UiState.Max(digits.toString())
            else if (digits < max && digits < step)
                UiState.Min(digits.toString())
            else UiState.Base(digits.toString())

        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            return if (result < max)
                UiState.Base(result.toString())
            else
                UiState.Max(result.toString())
        }

        override fun decrement(number: String): UiState {
            val digits = number.toInt()
            val result = digits - step
            return if (result > min)
                UiState.Base(result.toString())
            else
                UiState.Min(result.toString())
        }
    }

}