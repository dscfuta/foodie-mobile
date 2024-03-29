package mobile.dscfuta.foodie.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mobile.dscfuta.foodie.database.*
import mobile.dscfuta.foodie.remote.APIService
import mobile.dscfuta.foodie.utils.APIUtils
import mobile.dscfuta.foodie.utils.SharedprefManager
import mobile.dscfuta.foodie.utils.SharedprefManager.usertoken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService: APIService = APIUtils.apiService

    private object SingletonHelper {
        val INSTANCE = Repository()
    }

    lateinit var Spref: SharedPreferences

    //setting up shareprefence
    fun setShareprefContext(context: Context) {
        Spref = SharedprefManager.customPreference(context, "PrefsType")!!
    }

    companion object {

        fun getInstance() : Repository {

            return SingletonHelper.INSTANCE
        }
    }

    fun login(email: String, password: String, token:String ) : LiveData<Login>{

        val data = MutableLiveData<Login>()
        apiService.login(email = email, password = password, token = token).enqueue(
            object : Callback<Login> {
                override fun onResponse(
                    call: Call<Login>,
                    response: Response<Login>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }

    fun register(email: String, phone: String, username: String,
                 password: String, address:String): LiveData<Registration>{

        val data = MutableLiveData<Registration>()
        apiService.register(email = email,password = password,phone = phone,username = username,
            address = address).enqueue(
            object : Callback<Registration> {
                override fun onResponse(
                    call: Call<Registration>,
                    response: Response<Registration>
                ) {
                    if (response.isSuccessful) {

                        data.value = response.body()
                        Spref.usertoken
                    }
                }

                override fun onFailure(call: Call<Registration>, t: Throwable) {
                    data.value = null
                }
            }
        )

        return data
    }

    fun getUserProfile(token:String) : LiveData<User> {
        val data = MutableLiveData<User>()
        apiService.getUserProfile(token).enqueue(
            object : Callback<User> {
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
    fun updateProfile(email: String, phone: String, username: String, address:String,token:String)
            : LiveData<userProfile>{

        val data = MutableLiveData<userProfile>()
        apiService.updateProfile(email = email ,phone = phone,username = username,
            address = address,token = token ).enqueue(
            object : Callback<userProfile> {
                override fun onResponse(
                    call: Call<userProfile>,
                    response: Response<userProfile>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<userProfile>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
    fun getAllRecipe(token:String) : LiveData<List<Recipe>> {
        val data = MutableLiveData<List<Recipe>>()
        apiService.getAllRecipe(token).enqueue(
            object : Callback<List<Recipe>> {
                override fun onResponse(
                    call: Call<List<Recipe>>,
                    response: Response<List<Recipe>>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
    fun getSingleRecipe(recipeId:String,token:String) : LiveData<Recipe> {
        val data = MutableLiveData<Recipe>()
        apiService.getSingleRecipe(recipeId, token).enqueue(
            object : Callback<Recipe> {
                override fun onResponse(
                    call: Call<Recipe>,
                    response: Response<Recipe>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Recipe>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
    fun getCart(token:String) : LiveData<List<CartData>> {
        val data = MutableLiveData<List<CartData>>()
        apiService.getCartData(token).enqueue(
            object : Callback<List<CartData>> {
                override fun onResponse(
                    call: Call<List<CartData>>,
                    response: Response<List<CartData>>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<CartData>>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
    fun addToCart(recipeId:String, token:String) : LiveData<CartResponse> {
        val data = MutableLiveData<CartResponse>()
        apiService.addCartData(recipeId = recipeId, token = token).enqueue(
            object : Callback<CartResponse> {
                override fun onResponse(
                    call: Call<CartResponse>,
                    response: Response<CartResponse>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
    fun delteFromCart(recipeId:String, token:String) : LiveData<CartResponse> {
        val data = MutableLiveData<CartResponse>()
        apiService.deleteCart(recipeId =recipeId, token=token).enqueue(
            object : Callback<CartResponse> {
                override fun onResponse(
                    call: Call<CartResponse>,
                    response: Response<CartResponse>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                    data.value = null
                }
            }
        )
        return data
    }
}