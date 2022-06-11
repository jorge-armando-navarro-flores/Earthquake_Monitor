package com.example.earthquakemonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquakemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList: MutableList<Earthquake> = mutableListOf()
        eqList.add(Earthquake("1", "57 km E of NY", 4.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("2", "Lima", 2.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("3", "Ciudad de mexico", 6.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("4", "Bogota", 1.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("5", "Caracas", 3.3, 273846152L, -102.4756, 28.47365))

        val adapter = EqAdapter(eqList)
        binding.eqRecycler.adapter = adapter

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

        if (eqList.isEmpty()) {
            binding.eqEmptyView.visibility = View.VISIBLE
        } else {
            binding.eqEmptyView.visibility = View.GONE
        }


    }
}