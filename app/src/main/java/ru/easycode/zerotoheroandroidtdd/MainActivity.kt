package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {

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

        viewModel.liveData().observe(this) { state ->
            state.apply(binding.actionButton, binding.progressBar, binding.titleTextView)
        }

        binding.actionButton.setOnClickListener {
            viewModel.load()
        }

    }
}