package mobile.dscfuta.foodie.destinations


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_all_recipe.*
import mobile.dscfuta.foodie.utils.SharedprefManager.usertoken
import mobile.dscfuta.foodie.utils.SharedprefManager.name

import mobile.dscfuta.foodie.R
import mobile.dscfuta.foodie.adapters.AllRecipeAdapter
import mobile.dscfuta.foodie.viewmodel.CustomViewModel


class AllRecipeFragment : Fragment() {

    lateinit var customViewModel: CustomViewModel
    lateinit var allRecipeAdapter: AllRecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customViewModel = CustomViewModel()

        val SPrefs = customViewModel.setShareprefContext(context!!)

        val allRecipe = customViewModel.getAllRecipe(SPrefs!!.usertoken)

        helloTitle.text = "Hello,  " + SPrefs!!.name

        allRecipeAdapter = AllRecipeAdapter(context!!, allRecipe.value!!.toMutableList())

        mealsRecycler.setLayoutManager(LinearLayoutManager(context))
        mealsRecycler.setAdapter(allRecipeAdapter)

        carticon.setOnClickListener {
            view.findNavController().navigate(R.id.ordersListsFragment)
        }
    }
}
