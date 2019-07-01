package mobile.dscfuta.foodie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mobile.dscfuta.foodie.database.*
import mobile.dscfuta.foodie.repository.Repository

class CustomViewModel : ViewModel(){

    fun login(email: String, password: String) : LiveData<Login>{
        return Repository.getInstance().login(email,password)
    }

    fun  register(email: String, phone: String, username: String, password: String, address:String)
            : LiveData<Registration>{
        return Repository.getInstance().register(email,phone,username,password,address)
    }

    fun getUserProfile() : LiveData<User> {
        return Repository.getInstance().getUserProfile( )
    }

    fun updateProfile(email: String, phone: String, username: String, address:String)
            : LiveData<userProfile>{
        return Repository.getInstance().updateProfile(email,phone,username,address)
    }

    fun getAllRecipe() : LiveData<List<Recipe>> {
        return Repository.getInstance().getAllRecipe( )
    }

    fun getSingleRecipe(recipeId:String) : LiveData<Recipe> {
        return Repository.getInstance().getSingleRecipe( recipeId)
    }

    fun getCart() : LiveData<List<CartData>> {
        return Repository.getInstance().getCart( )
    }

    fun addToCart(recipeId:String) : LiveData<CartResponse> {
        return Repository.getInstance().addToCart( recipeId)
    }

    fun delteFromCart(recipeId:String) : LiveData<CartResponse> {
        return Repository.getInstance().delteFromCart(recipeId)
    }

}