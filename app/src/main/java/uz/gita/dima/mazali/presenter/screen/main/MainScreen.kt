package uz.gita.dima.mazali.presenter.screen.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.dima.mazali.R
import uz.gita.dima.mazali.data.Food
import uz.gita.dima.mazali.databinding.ScreenMainBinding
import uz.gita.dima.mazali.presenter.adapter.maxbox.OuterAdapter
import uz.gita.dima.mazali.presenter.screen.main.viewmodel.MainViewModel
import uz.gita.dima.mazali.presenter.screen.main.viewmodel.impl.MainViewModelImpl
import javax.inject.Inject

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {

    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

//    @Inject
//    lateinit var mainMaxBoxAdapter: OuterAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllFoods()
        viewModel.allFood.observe(viewLifecycleOwner) {
//            Log.d("WWW", "Foods -> $it")
//            mainMaxBoxAdapter.submitList(it)

            Log.d("WWW", "Foods -> $it")
            val outerAdapter = OuterAdapter(it as ArrayList<Food>)
            binding.mainRV.adapter = outerAdapter
        }
        viewModel.errorMessage.observe(viewLifecycleOwner, errorMessageObserver)

//        val layoutManager = StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)
//        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
//        binding.mainRV.layoutManager = layoutManager

//        binding.mainRV.adapter = mainMaxBoxAdapter
    }

//    private val foodObserver = Observer<List<Food>> {
//        Log.d("ALI", "Foods -> $it")
//        mainMaxBoxAdapter.submitList(it)
//    }

    private val errorMessageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
}