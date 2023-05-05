package uz.gita.dima.mazali.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.dima.mazali.data.Food
import uz.gita.dima.mazali.data.FoodDetails

interface MainRepository {

    fun getAllFood(): Flow<Result<List<FoodDetails>>>

    fun getResult(): Flow<Result<List<Food>>>
}