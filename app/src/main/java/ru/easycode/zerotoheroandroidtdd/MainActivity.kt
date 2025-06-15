package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
private val count = Count.Base(step = 2)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.incrementButton.setOnClickListener {
            val result = count.increment(binding.countTextView.text.toString())
            binding.countTextView.text = result

        }
    }




}