package com.examplek.task_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.examplek.task_1.Repository.WeatherRepository
import com.examplek.task_1.db.WeatherDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: WeatherViewModel
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weatherRepository=WeatherRepository(WeatherDatabase(this))
        val viewModelProviderFactory=WeatherViewModelProviderFactory(weatherRepository)
        Log.d(tag, "onCreate: Hello ")
        viewModel= ViewModelProvider(this,viewModelProviderFactory)[WeatherViewModel::class.java]
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.weathernavHostfragment) as NavHostFragment
        val navController= navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}