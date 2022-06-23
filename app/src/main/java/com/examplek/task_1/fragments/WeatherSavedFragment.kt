package com.examplek.task_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.examplek.task_1.*
import com.examplek.task_1.databinding.SavedWeatherBinding
import com.examplek.task_1.databinding.SearchWeatherBinding
//import com.examplek.task_1.UserViewModel
import kotlinx.android.synthetic.main.saved_weather.view.*

class WeatherSavedFragment : Fragment(R.layout.saved_weather) {
    private var _binding: SavedWeatherBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= SavedWeatherBinding.inflate(inflater, container, false)
        return binding.root

    }
    lateinit var viewModel: WeatherViewModel
    lateinit var weatherAdapter: Weather_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewModel
//        val weatherAdapter:Weather_Adapter= Weather_Adapter()
setupRecyclerView()
        viewModel.getSavedDetails().observe(viewLifecycleOwner, Observer {details ->weatherAdapter.differ.submitList(details)
        })}
        private fun setupRecyclerView() {
            weatherAdapter = Weather_Adapter()
            binding.recyclerview.apply {
                adapter = weatherAdapter
                layoutManager = LinearLayoutManager(activity)
            }
    }
}