package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

interface UiState {

    fun apply(progressBar: ProgressBar, button: Button, textView: TextView)

    class ShowProgress() : UiState {
        override fun apply(progressBar: ProgressBar, button: Button, textView: TextView) {
            progressBar.isVisible = true
            button.isEnabled = false
        }

    }


    class ShowData() : UiState {
        override fun apply(progressBar: ProgressBar, button: Button, textView: TextView) {
            progressBar.isVisible = false
            button.isEnabled = true
            textView.isVisible = true
        }

    }

}