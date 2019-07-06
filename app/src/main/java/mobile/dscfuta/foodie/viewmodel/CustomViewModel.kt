package mobile.dscfuta.foodie.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mobile.dscfuta.foodie.database.*
import mobile.dscfuta.foodie.repository.Repository
import mobile.dscfuta.foodie.utils.SharedprefManager

class CustomViewModel : ViewModel() {

    //setting up shareprefence
    fun setShareprefContext(context: Context): SharedPreferences? {
        return SharedprefManager.customPreference(context, "PrefsType")
    }

    //
    fun login(email: String, password: String, token:String) : LiveData<Login>{
        return Repository.getInstance().login(email,password,token)
    }

    //returns Register object. Get user token from it and save to shprefs. the token is needed
    //to be passed to every api calls
    fun  register(email: String, phone: String, username: String, password: String, address:String)
            : LiveData<Registration> {
        return Repository.getInstance().register(email,phone,username,password,address)
    }

    ///return the user profile information including name, email e.t.c
    fun getUserProfile(token:String) : LiveData<User> {
        return Repository.getInstance().getUserProfile(token)
    }

    fun updateProfile(email: String, phone: String, username: String, address:String,token:String)
            : LiveData<userProfile>{
        return Repository.getInstance().updateProfile(email,phone,username,address,token)
    }

    fun getAllRecipe(token:String) : LiveData<List<Recipe>> {
        return Repository.getInstance().getAllRecipe( token)
    }

    fun getSingleRecipe(recipeId:String,token:String) : LiveData<Recipe> {
        return Repository.getInstance().getSingleRecipe( recipeId,token)
    }

    fun getCart(token:String) : LiveData<List<CartData>> {
        return Repository.getInstance().getCart(token )
    }

    fun addToCart(recipeId:String,token:String) : LiveData<CartResponse> {
        return Repository.getInstance().addToCart(recipeId, token)
    }

    fun delteFromCart(recipeId:String,token:String) : LiveData<CartResponse> {
        return Repository.getInstance().delteFromCart(recipeId,token)
    }
}