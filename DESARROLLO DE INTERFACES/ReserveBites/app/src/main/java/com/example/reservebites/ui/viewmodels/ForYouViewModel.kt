package com.example.reservebites.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reservebites.data.models.RestaurantCard
import com.example.reservebites.data.repositories.ForYouRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForYouViewModel: ViewModel() {
    private val forYouRepository = ForYouRepository()

    init {
        getRestaurantList()
    }

    private var _restaurantList = MutableLiveData<List<RestaurantCard>>()
    val restaurantList: LiveData<List<RestaurantCard>> = _restaurantList
    private fun getRestaurantList() {
        viewModelScope.launch {
            val loadedRestaurantList = withContext(Dispatchers.IO) {
                forYouRepository.getRestaurantList()
            }
            _restaurantList.postValue(loadedRestaurantList)
        }
    }
}