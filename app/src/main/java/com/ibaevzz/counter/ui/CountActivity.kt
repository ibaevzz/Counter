package com.ibaevzz.counter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ibaevzz.counter.databinding.ActivityCountBinding
import com.ibaevzz.counter.view_models.CountViewModel

class CountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountBinding
    private val viewModel by lazy{
        ViewModelProvider(this)[CountViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}