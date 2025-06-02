package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        savedInstanceState?.let { binding.titleTextView.text = savedInstanceState.getString(KEY).toString() }



        binding.changeButton.setOnClickListener {
            binding.titleTextView.text =
                getString(R.string.i_am_an_android_developera)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key",getString(R.string.i_am_an_android_developera))
    }

    companion object {
        const val KEY = "key"
    }

}