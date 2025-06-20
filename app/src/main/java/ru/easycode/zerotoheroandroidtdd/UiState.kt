@file:Suppress("DEPRECATED_ANNOTATION")

package ru.easycode.zerotoheroandroidtdd


import android.os.Parcelable
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible




interface UiState: Parcelable{

    fun apply(button: Button, progressBar: ProgressBar,textView: TextView)


    @kotlinx.android.parcel.Parcelize
    object ShowProgress : UiState {
        override fun apply(button: Button, progressBar: ProgressBar, textView: TextView) {
            button.isEnabled = false
            progressBar.isVisible = true
        }

    }

   @kotlinx.android.parcel.Parcelize
    object ShowData : UiState {
        override fun apply(button: Button, progressBar: ProgressBar, textView: TextView) {
            button.isEnabled = true
            progressBar.isVisible = false
            textView.isVisible = true
        }

    }

}