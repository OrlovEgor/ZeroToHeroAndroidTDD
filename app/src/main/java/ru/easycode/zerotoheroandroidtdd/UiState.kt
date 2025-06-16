package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface UiState {

    fun apply(incrementButton: Button, decrementButton: Button, textView: TextView)

    data class Base(val text: String): UiState {
        override fun apply(
            incrementButton: Button,
            decrementButton: Button,
            textView: TextView
        ) {
            TODO("Not yet implemented")
        }
    }

    data class Max(val text: String): UiState {
        override fun apply(
            incrementButton: Button,
            decrementButton: Button,
            textView: TextView
        ) {
            TODO("Not yet implemented")
        }
    }

    data class Min(val text: String): UiState {
        override fun apply(
            incrementButton: Button,
            decrementButton: Button,
            textView: TextView
        ) {
            TODO("Not yet implemented")
        }
    }

}