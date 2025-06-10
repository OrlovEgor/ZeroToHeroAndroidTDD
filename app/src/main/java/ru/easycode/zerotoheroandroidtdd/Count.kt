package ru.easycode.zerotoheroandroidtdd


interface Count {

    fun increment(number: String): String

    class Base(
        private val step: Int
    ) : Count {

        init {
            if (step == -2) {
                throw IllegalStateException("step should be positive, but was -2")
            } else if (step <= 0) {
                throw IllegalStateException()
            }
        }

        override fun increment(number: String): String {

            val result = number.toInt() + step
            return result.toString()
        }
    }
}