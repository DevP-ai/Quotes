package com.dev.android.quotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dev.android.quotes.databinding.ActivityMainBinding
import com.dev.android.quotes.factory.MainViewModelFactory
import com.dev.android.quotes.model.Quote
import com.dev.android.quotes.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel= ViewModelProvider(this,MainViewModelFactory(application))[MainViewModel::class.java]

        setQuote(mainViewModel.getQuote())

        binding.txtNext.setOnClickListener {
           onNext()
        }

        binding.txtPrev.setOnClickListener {
            onPrev()
        }

        binding.btnShare.setOnClickListener {
            onShare()
        }

    }

    private fun onShare() {
        val intent=Intent(Intent.ACTION_SEND)
        intent.setType("text/plane")
        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
        startActivity(intent)
    }

    private fun onPrev() {
        setQuote(mainViewModel.previousQuote())
    }

    private fun onNext() {
       setQuote(mainViewModel.nextQuote())
    }

    private fun setQuote(quote: Quote) {
       binding.txtQuotes.text=quote.text
       binding.authorName.text=quote.author
    }
}