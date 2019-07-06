package mobile.dscfuta.foodie.destinations


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_all_recipe.*

import mobile.dscfuta.foodie.R
import mobile.dscfuta.foodie.adapters.AllRecipeAdapter
import mobile.dscfuta.foodie.adapters.CartRecipeAdapter
import mobile.dscfuta.foodie.utils.SharedprefManager.name
import mobile.dscfuta.foodie.utils.SharedprefManager.usertoken
import mobile.dscfuta.foodie.viewmodel.CustomViewModel

class OrdersListsFragment : Fragment() {

    lateinit var customViewModel: CustomViewModel
    lateinit var cartRecipeAdapter: CartRecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customViewModel = CustomViewModel()

        val SPrefs = customViewModel.setShareprefContext(context!!)

        val allCart = customViewModel.getCart(SPrefs!!.usertoken)

        cartRecipeAdapter = CartRecipeAdapter(context!!, allCart.value!!.toMutableList())

        mealsRecycler.setLayoutManager(LinearLayoutManager(context))
        mealsRecycler.setAdapter(cartRecipeAdapter)
    }
}
