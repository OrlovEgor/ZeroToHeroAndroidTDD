package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


interface UiState: Parcelable {

    fun apply(button: Button,textView: TextView)

    @kotlinx.parcelize.Parcelize
    data class Base(
        private val text: String
    ) : UiState {

        override fun apply( button: Button,textView: TextView) {
            textView.text = text
        }

    }
    @kotlinx.parcelize.Parcelize
        data class Max(
            private val text: String
        ) : UiState {
            override fun apply( button: Button,textView: TextView) {
                textView.text = text
                button.isEnabled = false
            }

        }
    }
