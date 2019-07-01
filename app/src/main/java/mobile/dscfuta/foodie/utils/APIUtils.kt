package mobile.dscfuta.foodie.utils

import mobile.dscfuta.foodie.remote.APIService
import mobile.dscfuta.foodie.remote.RetrofitClient

object APIUtils {
    val BASE_URL = "https://dsc-foodie.herokuapp.com/api/"
    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)
}