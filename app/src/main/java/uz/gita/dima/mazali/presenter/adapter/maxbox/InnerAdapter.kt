package uz.gita.dima.mazali.presenter.adapter.maxbox

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.dima.mazali.R
import uz.gita.dima.mazali.data.FoodDetails
import uz.gita.dima.mazali.databinding.ItemFoodDetailsBinding

class InnerAdapter(val list: List<FoodDetails>) : RecyclerView.Adapter<InnerAdapter.InnerViewHolder>(){

    inner class InnerViewHolder(private val binding: ItemFoodDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

        }

        @SuppressLint("SetTextI18n")
        fun bind(foodDetails: FoodDetails) {
            binding.apply {
//                Log.d("RRR","Food Name -> ${foodDetails.name}")
//                Log.d("RRR","Food Description -> ${foodDetails.description}")
//                Log.d("RRR","Food Price -> ${foodDetails.price}")
                imageFood.setImageResource(R.drawable.img)
                Glide.with(itemView.context)
                    .load(foodDetails.imageUrl)
                    .into(imageFood)
                textFoodTitle.text = foodDetails.name
                textFoodDescription.text = foodDetails.description
                textFoodPrice.text = "${foodDetails.price.toString()} so'm"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        return InnerViewHolder(
            ItemFoodDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.bind(list[position])
    }
}