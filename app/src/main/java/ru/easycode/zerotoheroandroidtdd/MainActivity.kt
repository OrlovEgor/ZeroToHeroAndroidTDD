package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        savedInstanceState?.let {
            if (!savedInstanceState.getBoolean(KEYTEXT)){
                binding.rootLayout.removeView(binding.titleTextView)
            }
            binding.removeButton.isEnabled = savedInstanceState.getBoolean(KEYBUTTON)
        }


        binding.removeButton.setOnClickListener {
            binding.rootLayout.removeView(binding.titleTextView)
            it.isEnabled = false
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBoolean(KEYBUTTON, binding.removeButton.isEnabled)
        outState.putBoolean(KEYTEXT, binding.titleTextView.isAttachedToWindow)
    }

    companion object {
        const val KEYBUTTON = "keyButton"
        const val KEYTEXT = "keyText"
    }
}