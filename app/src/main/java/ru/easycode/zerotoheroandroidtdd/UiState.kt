package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import java.io.Serializable

interface UiState: Serializable {

    fun enabled(linearLayout: LinearLayout, button: Button)

    data class Base(
        private val text: String
    ) : UiState {

        override fun enabled(linearLayout: LinearLayout, button: Button) {
        }
    }
        data class Max(
            private val text: String
        ) : UiState {
            override fun enabled(
                linearLayout: LinearLayout, button: Button
            ) {
                button.isEnabled = false
            }
        }
    }
