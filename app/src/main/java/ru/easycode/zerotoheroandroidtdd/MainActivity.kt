package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())

    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState != null) {
            viewModel.restore(BundleWrapper.Base(savedInstanceState))
        }

        viewModel.liveData().observe(this) {
            state-> state.apply(binding.actionButton,binding.progressBar,binding.titleTextView)
        }

        binding.actionButton.setOnClickListener {
            viewModel.load()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

    }


}