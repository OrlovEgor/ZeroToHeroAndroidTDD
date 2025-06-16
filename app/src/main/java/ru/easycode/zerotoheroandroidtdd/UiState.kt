package ru.easycode.zerotoheroandroidtdd

import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import kotlinx.android.parcel.Parcelize

interface UiState: Parcelable {

    fun apply(incrementButton: Button, decrementButton: Button, textView: TextView)

@kotlinx.parcelize.Parcelize
    data class Base(val text: String): UiState {
        override fun apply(
            incrementButton: Button,
            decrementButton: Button,
            textView: TextView
        ) {
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
            textView.text = text
        }
    }
    @kotlinx.parcelize.Parcelize
    data class Max(val text: String): UiState {
        override fun apply(
            incrementButton: Button,
            decrementButton: Button,
            textView: TextView
        ) {
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
            textView.text = text
        }
    }
    @kotlinx.parcelize.Parcelize
    data class Min(val text: String): UiState {
        override fun apply(
            incrementButton: Button,
            decrementButton: Button,
            textView: TextView
        ) {
            incrementButton.isEnabled = true
            decrementButton.isEnabled = false
            textView.text = text
        }
    }

}