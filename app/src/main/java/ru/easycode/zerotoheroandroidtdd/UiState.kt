@file:Suppress("DEPRECATED_ANNOTATION")

package ru.easycode.zerotoheroandroidtdd


import android.os.Parcelable
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.parcel.Parcelize



interface UiState: Parcelable {

    fun apply(button: Button, progressBar: ProgressBar,textView: TextView)


    @Parcelize
    object ShowProgress : UiState {
        override fun apply(button: Button, progressBar: ProgressBar, textView: TextView) {
            button.isEnabled = false
            progressBar.isVisible = true
        }

    }

    @Parcelize
    object ShowData : UiState {
        override fun apply(button: Button, progressBar: ProgressBar, textView: TextView) {
            button.isEnabled = true
            progressBar.isVisible = false
            textView.isEnabled = true
        }

    }

}