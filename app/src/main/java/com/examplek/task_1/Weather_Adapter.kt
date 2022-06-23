package com.examplek.task_1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_detail_preview.view.*

class Weather_Adapter : RecyclerView.Adapter<Weather_Adapter.WeatherViewHolder>() {
    inner class WeatherViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    private val differcallback =object: DiffUtil.ItemCallback<SavingDataType>(){
        override fun areContentsTheSame(oldItem: SavingDataType, newItem: SavingDataType): Boolean {
            return (oldItem == newItem)
        }

        override fun areItemsTheSame(oldItem: SavingDataType, newItem: SavingDataType): Boolean {
            return (oldItem.nameOfUser==newItem.nameOfUser && oldItem.cityOfUser==newItem.cityOfUser
                    && oldItem.countryOfUser==newItem.countryOfUser)
        }
    }
    val differ=AsyncListDiffer(this,differcallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_detail_preview,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherdetail=differ.currentList[position]
        holder.itemView.apply {
            Name_txt.text=weatherdetail.nameOfUser
            country_txt.text=weatherdetail.countryOfUser
            city_txt.text=weatherdetail.cityOfUser
            setOnClickListener{
                onItemClickListener?.let { it(weatherdetail) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
private var onItemClickListener: ((SavingDataType)->Unit)?=null
fun setOnItemClickListener(listener: (SavingDataType)->Unit)
{
    onItemClickListener=listener
}