package com.example.earthquakemonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _eqList = MutableLiveData<MutableList<Earthquake>>()
    val eqList: LiveData<MutableList<Earthquake>>
        get() = _eqList

    init {
        fetchEarthquakes()
    }

    private fun fetchEarthquakes() {
        val eqList: MutableList<Earthquake> = mutableListOf()
        eqList.add(Earthquake("1", "57 km E of NY", 4.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("2", "Lima", 2.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("3", "Ciudad de mexico", 6.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("4", "Bogota", 1.3, 273846152L, -102.4756, 28.47365))
        eqList.add(Earthquake("5", "Caracas", 3.3, 273846152L, -102.4756, 28.47365))

        _eqList.value = eqList
    }
}