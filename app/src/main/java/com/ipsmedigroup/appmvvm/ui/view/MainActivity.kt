package com.ipsmedigroup.appmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.ipsmedigroup.appmvvm.R
import com.ipsmedigroup.appmvvm.databinding.ActivityMainBinding
import com.ipsmedigroup.appmvvm.ui.viewModel.QuoteViewModel


class MainActivity : AppCompatActivity() {
    private val quoteViewModel : QuoteViewModel by viewModels()
    //se hace la relacion
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()


        quoteViewModel.quoteModel.observe(this) {
            //_todo lo que este aqui dentro se queda enganchando ala modelview
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
            // cada que exista un cambio en livedata se refleja en este apartado
        }

        quoteViewModel.isLoading.observe(this){
            binding.ProgresBar.isVisible = it
            binding.tvQuote.isVisible = !it
            binding.tvAuthor.isVisible = !it
        }

       binding.viewContainer.setOnClickListener{ quoteViewModel.quoteGet()}
    }


}