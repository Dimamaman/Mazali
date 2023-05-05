package uz.gita.dima.mazali.data

data class Food(
    val id: Long = 0,
    val name: String,
    val list: List<FoodDetails>
)
