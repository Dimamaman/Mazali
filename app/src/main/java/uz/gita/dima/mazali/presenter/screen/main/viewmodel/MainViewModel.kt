package uz.gita.dima.mazali.presenter.screen.main.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.dima.mazali.data.Food

interface MainViewModel {
    val allFood: LiveData<List<Food>>
    val errorMessage: LiveData<String>
    fun getAllFoods()
}