package uz.gita.dima.mazali.domain.impl

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import uz.gita.dima.mazali.data.Food
import uz.gita.dima.mazali.data.FoodDetails
import uz.gita.dima.mazali.domain.MainRepository
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor() : MainRepository {
    private val db = Firebase.firestore

    override fun getAllFood(): Flow<Result<List<FoodDetails>>> = callbackFlow {

        awaitClose()
    }
    private suspend fun getList(): Result<List<Food>> {
        try {
            val a = db.collection("MaxWay")
                .get()
                .await()

            val resultList = arrayListOf<Food>()

            a.documents.forEach {
                val foodList = arrayListOf<FoodDetails>()
                val subCollection = it.reference.collection("list").get().await()
                subCollection.forEach {
                    foodList.add(it.toObject(FoodDetails::class.java))
                }
                resultList.add(
                    Food(
                        id = it.get("id") as Long,
                        name = it.get("title") as String,
                        list = foodList
                    )
                )
            }
            return Result.success(resultList)
        } catch (e: java.lang.Exception) {
            return Result.failure(e)
        }
    }

    override fun getResult(): Flow<Result<List<Food>>> {
        return flow {
            emit(getList())
        }.flowOn(Dispatchers.IO)
    }
}