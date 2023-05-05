package uz.gita.dima.mazali.presenter.adapter.maxbox

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import uz.gita.dima.mazali.data.Food
import uz.gita.dima.mazali.databinding.ItemLayoutBinding
import javax.inject.Inject

class OuterAdapter(private val list: ArrayList<Food>) :
    RecyclerView.Adapter<OuterAdapter.OuterViewHolder>() {

    /*@Inject
    lateinit var baseMaxBoxAdapter: InnerAdapter

    @Inject
    lateinit var innerAdapter: InnerAdapter*/

    inner class OuterViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            binding.apply {
                textFoodTitle.text = food.name
                val myAdapter = InnerAdapter(food.list)
                val layoutManager = StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)
                layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                rv.layoutManager = layoutManager
                rv.adapter = myAdapter
                Log.d("RRR", "Sub List -> ${food.list}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder =
        OuterViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        holder.bind(list[position])
    }
}