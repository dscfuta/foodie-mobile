package mobile.dscfuta.foodie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import mobile.dscfuta.foodie.R
import mobile.dscfuta.foodie.database.Recipe
import java.util.ArrayList

class AllRecipeAdapter(internal var context: Context, itemRecipeList: MutableList<Recipe>): RecyclerView.Adapter<AllRecipeAdapter.ViewHolder>() {

    var recipeList: MutableList<Recipe> = ArrayList()

    init {

        this.recipeList = itemRecipeList
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun getRecipe(position: Int) : Recipe {
        return recipeList[position]
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {

        holder.constraintLayout.setOnClickListener {

            getRecipe(position).name

            it.findNavController().navigate(R.id.recipeDetailsFragment)

        }
    }

    fun addRecipeList(newRecipeList: List<Recipe>?) {
        if (newRecipeList != null) {
            recipeList.addAll(newRecipeList)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var constraintLayout: ConstraintLayout

        init {

            constraintLayout = itemView.findViewById(R.id.itemRecipieView)
        }
    }
}
