package com.ibaevzz.counter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ibaevzz.counter.databinding.ActivityMainBinding
import com.ibaevzz.counter.view_models.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.getCount().collect{
                withContext(Dispatchers.Main){
                    binding.count.text = it.toString()
                }
            }
        }
        binding.plus.setOnClickListener{
            viewModel.plus()
        }
        binding.minus.setOnClickListener{
            viewModel.minus()
        }
        binding.calendar.setOnClickListener{
            startActivity(Intent(this, CountActivity::class.java))
        }
    }
}