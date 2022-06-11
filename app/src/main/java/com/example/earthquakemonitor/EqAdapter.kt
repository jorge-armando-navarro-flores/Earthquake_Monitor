package com.example.earthquakemonitor

import android.media.audiofx.DynamicsProcessing
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakemonitor.databinding.EqListItemBinding

private val TAG = EqAdapter::class.java.simpleName
class EqAdapter (
    private val dataset: List<Earthquake>
        ): RecyclerView.Adapter<EqAdapter.EqViewHolder>() {


    lateinit var onItemClickListener: (Earthquake) -> Unit

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
            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized){
                    onItemClickListener(earthquake)
                } else {
                    Log.e(TAG, "onItemClickListener not initialized")
                }

            }
            binding.executePendingBindings()
        }
    }

    override fun getItemCount() = dataset.size
}