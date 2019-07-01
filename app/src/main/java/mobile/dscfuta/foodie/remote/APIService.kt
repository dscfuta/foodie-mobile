package mobile.dscfuta.foodie.remote

import android.provider.ContactsContract
import mobile.dscfuta.foodie.database.*
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("profile")
    fun getUserProfile() : Call<User>

    @GET("recipe/all")
    fun getAllRecipe(): Call<List<Recipe>>

    @GET("recipe")
    fun getSingleRecipe(@Field("recipeId") recipeId: String): Call<Recipe>

    @GET("cart")
    fun getCartData(): Call<List<CartData>>

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("register")
    @FormUrlEncoded
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
        @Field("username") username: String,
        @Field("address") address: String
    ): Call<Registration>

    @PUT("profile")
    @FormUrlEncoded
    fun updateProfile(
        @Field("email") email: String,
        @Field("email") phone: String,
        @Field("password") username: String,
        @Field("email") address: String
    ): Call<userProfile>

    @POST("cart/add")
    @FormUrlEncoded
    fun addCartData(
        @Field("recipeId") email: String
    ): Call<CartResponse>

    @DELETE("cart/remove")
    @FormUrlEncoded
    fun deleteCart(
        @Field("recipeId") email: String
    ): Call<CartResponse>
}