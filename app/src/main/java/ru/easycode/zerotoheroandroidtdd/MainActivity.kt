package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
private var count = 0
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.incrementButton.setOnClickListener {
            count +=2
            binding.countTextView.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val result =  savedInstanceState.getInt(KEY)
        binding.countTextView.text = count.toString()
        count = result
    }

    companion object {
        const val KEY ="key"
    }
}