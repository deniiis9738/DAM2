package com.example.reservebites.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reservebites.data.repositories.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestaurantViewModel: ViewModel() {
    private val restaurantRepository = RestaurantRepository()

    init {
        getReviewsList()
    }

    private var _reviewsList = MutableLiveData<List<String>>()
    val reviewsList: LiveData<List<String>> = _reviewsList

    fun getReviewsList() {
        viewModelScope.launch {
            val loadedRestaurantList = withContext(Dispatchers.IO) {
                restaurantRepository.getReviewsList()
            }
            _reviewsList.postValue(loadedRestaurantList)
        }
    }
}