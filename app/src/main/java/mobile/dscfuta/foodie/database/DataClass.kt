package mobile.dscfuta.foodie.database

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Login (

    @SerializedName("token")
    @Expose
    var token: String? = null,
    @SerializedName("user")
    @Expose
    var user: User? = null
)
data class Registration (

    @SerializedName("token")
    @Expose
    var token: String? = null,
    @SerializedName("user")
    @Expose
    var user: User? = null
)
data class User (
    @SerializedName("status")
    @Expose
    var status: Boolean? = null,
    @SerializedName("userid")
    @Expose
    var userid: String? = null,
    @SerializedName("surname")
    @Expose
    var surname: String? = null,
    @SerializedName("firstname")
    @Expose
    var firstname: String? = null,
    @SerializedName("email")
    @Expose
    var email: String? = null
)
data class userProfile (

    @SerializedName("status")
    @Expose
    var status: Boolean? = null,
    @SerializedName("message")
    @Expose
    var message: String? = null
)
data class Recipe (

    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("price")
    @Expose
    var price: String? = null
)
data class CartData (

    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("price")
    @Expose
    var price: String? = null
)
data class CartResponse (

    @SerializedName("status")
    @Expose
    var status: Boolean? = null,
    @SerializedName("cart_data")
    @Expose
    var cartData: CartData? = null

)