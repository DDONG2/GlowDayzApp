package com.example.glowdayzapp.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.glowdayzapp.BaseActivity
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.ActivityMainBinding
import com.example.glowdayzapp.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this).get(MainViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun createObserveData() {


    }
}