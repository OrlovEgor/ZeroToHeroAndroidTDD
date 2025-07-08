package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewTexts: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            val data = savedInstanceState.getStringArrayList(KEY)
            data?.let { viewTexts = data }
            viewTexts.forEach { text -> viewCreator(text) }
        } else {
            viewTexts = arrayListOf<String>()
        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()

            viewTexts.add(text)
            viewCreator(text)
            binding.inputEditText.setText("")
        }

    }

    private fun viewCreator(text: String) {

        val layout: LinearLayout = findViewById<LinearLayout>(R.id.contentLayout)

        val textView = TextView(this)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        textView.layoutParams = params
        textView.text = text
        layout.addView(textView)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, viewTexts)
    }

    companion object {
        private const val KEY = "key"
    }

}