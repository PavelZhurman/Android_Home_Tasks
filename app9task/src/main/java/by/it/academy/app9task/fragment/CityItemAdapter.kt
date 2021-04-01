package by.it.academy.app9task.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import by.it.academy.app9task.database.CityItem
import by.it.academy.app9task.databinding.ItemRecycleLayoutBinding

class CityItemAdapter(private var listener: OnCityClickListener) : RecyclerView.Adapter<CityItemAdapter.CitiesViewHolder>() {
    private var cityList: List<CityItem> = emptyList()

    fun addCity(cityName: List<CityItem>) {
        cityList = cityName
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CitiesViewHolder(ItemRecycleLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false))

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(cityList[position], listener)
    }

    override fun getItemCount() = cityList.size

    class CitiesViewHolder(private val binding: ItemRecycleLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: CityItem, listener: OnCityClickListener) {
            binding.cityName.text = city.city
            binding.root.setOnClickListener {
                binding.submitCheck.visibility = View.VISIBLE
                listener.onCityClick(city = city, viewNeedToCheck = binding.submitCheck, false)
            }

            binding.root.setOnLongClickListener {
                listener.onCityClick(city = city, viewNeedToCheck = binding.submitCheck, true)
                return@setOnLongClickListener true
            }
        }
    }

    interface OnCityClickListener {
        fun onCityClick(city: CityItem, viewNeedToCheck: ImageView, isLongClick: Boolean)
    }
}