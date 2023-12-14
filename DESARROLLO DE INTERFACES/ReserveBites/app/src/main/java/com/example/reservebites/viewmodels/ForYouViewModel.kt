package com.example.reservebites.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reservebites.data.models.RestaurantCard
import com.example.reservebites.data.repositories.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForYouViewModel: ViewModel() {
    private val restaurantRepository = RestaurantRepository()

    private var _restaurantList = MutableLiveData<List<RestaurantCard>>()
    val restaurantList: LiveData<List<RestaurantCard>> = _restaurantList
    fun getRestaurantList() {
        viewModelScope.launch {
            val loadedRestaurantList = withContext(Dispatchers.IO) {
                restaurantRepository.getRestaurantList()
            }
            _restaurantList.postValue(loadedRestaurantList)
        }
    }
}