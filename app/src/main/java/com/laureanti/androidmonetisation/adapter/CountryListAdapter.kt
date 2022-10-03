package com.laureanti.androidmonetisation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laureanti.androidmonetisation.R
import com.laureanti.androidmonetisation.model.Country

class CountryListAdapter(val countryes: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: ArrayList<Country>){
        countryes.clear()
        countryes.addAll(newCountries)
        notifyDataSetChanged()
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.imageView)
        private val countryName = view.findViewById<TextView>(R.id.name)
        private val capital = view.findViewById<TextView>(R.id.capital)

        fun bind(country: Country) {
            countryName.text = country.countryName
            capital.text = country.capital
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryes[position])
    }

    override fun getItemCount() = countryes.size
}