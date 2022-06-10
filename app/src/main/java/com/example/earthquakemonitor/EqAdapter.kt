package com.example.earthquakemonitor

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakemonitor.databinding.EqListItemBinding


class EqAdapter (
    private val dataset: List<Earthquake>
        ): RecyclerView.Adapter<EqAdapter.EqViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqAdapter.EqViewHolder {
        val binding = EqListItemBinding.inflate(LayoutInflater.from(parent.context))
        return EqViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EqAdapter.EqViewHolder, position: Int) {
        val earthquake = dataset[position]
        holder.bind(earthquake)
    }

    inner class EqViewHolder(private val binding: EqListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(earthquake: Earthquake){
            binding.eqMagnitudeText.text = earthquake.magnitude.toString()
            binding.eqPlaceText.text = earthquake.place
        }
    }

    override fun getItemCount() = dataset.size
}