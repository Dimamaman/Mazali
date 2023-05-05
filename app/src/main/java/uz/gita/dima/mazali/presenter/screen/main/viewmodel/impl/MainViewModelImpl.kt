package uz.gita.dima.mazali.presenter.screen.main.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.dima.mazali.data.Food
import uz.gita.dima.mazali.domain.MainRepository
import uz.gita.dima.mazali.presenter.screen.main.viewmodel.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val getMainRepository: MainRepository
): ViewModel(), MainViewModel {
    override val allFood = MutableLiveData<List<Food>>()
    override val errorMessage = MutableLiveData<String>()

    override fun getAllFoods() {
        getMainRepository.getResult().onEach {
            it.onSuccess {
                Log.d("NNN","Food List -> $it")
                allFood.value = it
            }

            it.onFailure {
                errorMessage.value = it.message
            }
        }.launchIn(viewModelScope)
    }
}