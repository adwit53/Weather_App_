package com.examplek.task_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.examplek.task_1.Api.RetrofitInstance
import com.examplek.task_1.MainActivity
import com.examplek.task_1.R
import com.examplek.task_1.SavingDataType
import com.examplek.task_1.WeatherViewModel
import com.examplek.task_1.databinding.SearchWeatherBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*
import kotlin.math.roundToInt

class WeatherSearchFragment : Fragment(R.layout.search_weather) {

    private lateinit var _binding: SearchWeatherBinding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=SearchWeatherBinding.inflate(inflater, container, false)
        return binding.root

    }
lateinit var viewModel: WeatherViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewModel
        binding.buttontosave.setOnClickListener {
            viewModel.saveWeatherDetails(SavingDataType(null,_binding?.name?.text.toString(),
                binding?.city?.text.toString(),
                binding?.country?.text.toString()))
        Snackbar.make(view,"Saved Successfully",Snackbar.LENGTH_SHORT).show()
        }
        binding.submitBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main)
                {
                    var response = RetrofitInstance.api.getWeatherData(
                        binding.city.text.toString(),
                        "2b5fec71b1698c3d2e726732e36ed43b"

                    )
                    if(response.isSuccessful)
                    {
                        var temperature:Double=response.body()!!.main.temp
                        temperature -= 273.15
                        val round = (temperature * 100.0).roundToInt() / 100.0
                       binding.temperatureTv.text= "$round C"
                    }
                    else
                    {
                        Toast.makeText(requireContext(),"Error 404",Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }

}