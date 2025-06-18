package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.isVisible
import androidx.transition.Visibility
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    val handler = Handler(Looper.getMainLooper())
        binding.progressBar.isVisible = false
        binding.titleTextView.isVisible = false
        binding.actionButton.setOnClickListener {
            binding.progressBar.isVisible = true
            binding.actionButton.isEnabled = false
            handler.postDelayed(
                {binding.progressBar.isVisible = false
                    binding.actionButton.isEnabled = true
                    binding.titleTextView.isVisible = true
                },3500
            )
        }

    }
}