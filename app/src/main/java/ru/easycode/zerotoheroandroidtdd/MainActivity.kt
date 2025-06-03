package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable



@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
private var state :State = State.Initial


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.removeButton.setOnClickListener {
            state = State.Removed
            state.apply(binding.rootLayout,binding.titleTextView)
            state.visible(binding.removeButton,false)
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putSerializable(KEYTEXT, state)
        outState.putBoolean(KEYBUTTON, binding.removeButton.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
       state =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEYTEXT, State::class.java)?: State.Removed
        } else {
            savedInstanceState.getSerializable(KEYTEXT) as State
        }
        state.visible(binding.removeButton,savedInstanceState.getBoolean(KEYBUTTON))
        state.apply(binding.rootLayout, binding.titleTextView)

    }


    companion object {
        const val KEYBUTTON = "keyButton"
        const val KEYTEXT = "keyText"
    }
}

interface State : Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView)
    fun visible(button: Button, isVisible: Boolean)

    object Initial: State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit
        override fun visible(button: Button, isVisible: Boolean)  = Unit
    }

    object Removed : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }

        override fun visible(button: Button, enabled : Boolean) {
            button.isEnabled = enabled
        }
    }
}