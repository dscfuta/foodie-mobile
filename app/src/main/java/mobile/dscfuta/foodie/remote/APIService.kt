package mobile.dscfuta.foodie.remote

import android.provider.ContactsContract
import mobile.dscfuta.foodie.database.*
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("profile")
    fun getUserProfile(@Header("Authorization" ) token:String
    ) : Call<User>

    @GET("recipe/all")
    fun getAllRecipe(@Header("Authorization" ) token:String
    ): Call<List<Recipe>>

    @GET("recipe")
    fun getSingleRecipe(@Header("Authorization" ) token:String,
                        @Field("recipeId") recipeId: String
    ): Call<Recipe>

    @GET("cart")
    fun getCartData(
        @Header("Authorization" ) token:String
    ): Call<List<CartData>>

    @POST("login")
    @FormUrlEncoded
    fun login(
        @Header("Authorization" ) token:String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("register")
    @FormUrlEncoded
    fun register(
        @Header("Authorization" ) token:String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
        @Field("username") username: String,
        @Field("address") address: String
    ): Call<Registration>

    @PUT("profile")
    @FormUrlEncoded
    fun updateProfile(
        @Header("Authorization" ) token:String,
        @Field("email") email: String,
        @Field("email") phone: String,
        @Field("password") username: String,
        @Field("email") address: String
    ): Call<userProfile>

    @POST("cart/add")
    @FormUrlEncoded
    fun addCartData(
        @Header("Authorization" ) token:String,
        @Field("recipeId") recipeId: String
    ): Call<CartResponse>

    @DELETE("cart/remove")
    @FormUrlEncoded
    fun deleteCart(
        @Header("Authorization" ) token:String,
        @Field("recipeId") recipeId: String
    ): Call<CartResponse>
}