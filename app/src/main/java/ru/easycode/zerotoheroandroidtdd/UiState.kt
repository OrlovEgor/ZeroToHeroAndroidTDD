package ru.easycode.zerotoheroandroidtdd

import android.os.Parcelable
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.parcel.Parcelize


interface UiState : Parcelable  {

    fun update(button: Button, progressBar: ProgressBar, textView: TextView)

    @Parcelize
    object ShowProgress: UiState {

        override fun update(
            button: Button,
            progressBar: ProgressBar,
            textView: TextView
        ) {
            button.isEnabled = false
            progressBar.isVisible = true
        }

    }

    @Parcelize
    data class ShowData( val text: String): UiState {

        override fun update(
            button: Button,
            progressBar: ProgressBar,
            textView: TextView
        ) {
            button.isEnabled = true
            progressBar.isVisible = false
            textView.isVisible = true
            textView.text = text
        }

    }
}