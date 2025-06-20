package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    private val viewModel: MainViewModel by lazy {
        val liveDataWrapper = LiveDataWrapper.Base()
        val repository = Repository.Base()
        val factory = MainViewModelFactory(liveDataWrapper, repository)
        ViewModelProvider(this, factory).get(MainViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState != null) {

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
        viewModel.restore(BundleWrapper.Base(savedInstanceState))
    }


}