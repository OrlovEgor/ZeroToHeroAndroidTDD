package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

private var count = Count.Base(step = 2, min = 0, max = 4)
private lateinit var state: UiState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        state = count.initial(binding.countTextView.text.toString())
        if (savedInstanceState == null){
            state.apply(binding.incrementButton,binding.decrementButton,binding.countTextView)
        }


        binding.incrementButton.setOnClickListener {
         state = count.increment(binding.countTextView.text.toString())
            state.apply(binding.incrementButton,binding.decrementButton,binding.countTextView)
        }

        binding.decrementButton.setOnClickListener {
          state = count.decrement(binding.countTextView.text.toString())
            state.apply(binding.incrementButton,binding.decrementButton,binding.countTextView)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val result = savedInstanceState.getParcelable<UiState>(KEY)
        state = result!!
        state.apply(binding.incrementButton,binding.decrementButton,binding.countTextView)
    }

    companion object {
        const val KEY = "Key"
    }

}