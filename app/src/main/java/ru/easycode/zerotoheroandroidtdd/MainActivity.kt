package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
private val count = Count.Base(step = 2, max = 4)
private lateinit var state : UiState

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.incrementButton.setOnClickListener {
            val result: UiState = count.increment(binding.countTextView.text.toString())
            state = result
            result.apply(binding.incrementButton,binding.countTextView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY,state)


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val  restoreState = savedInstanceState.getParcelable<UiState>(KEY)
        state = restoreState!!
        state.apply(binding.incrementButton, binding.countTextView)
    }
    companion object {
        private const val KEY ="key"
    }
}