package mobile.dscfuta.foodie.authentication


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.login
import kotlinx.android.synthetic.main.fragment_sign_up.password
import kotlinx.android.synthetic.main.fragment_sign_up.username
import mobile.dscfuta.foodie.utils.SharedprefManager.usertoken
import mobile.dscfuta.foodie.utils.SharedprefManager.name

import mobile.dscfuta.foodie.R
import mobile.dscfuta.foodie.utils.NetworkUtils
import mobile.dscfuta.foodie.viewmodel.CustomViewModel
import kotlinx.android.synthetic.main.fragment_login.signup as signup1


class SignUpFragment : Fragment() {

    lateinit var customViewModel: CustomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customViewModel = CustomViewModel()

        val SPrefs = customViewModel.setShareprefContext(context!!)

        signup.setOnClickListener {

            if(NetworkUtils.isConnected(context!!)) {

                if(collectSignupProfileData()) {

                    val data = customViewModel.register(username = username.getText().toString(),
                        email = email.getText().toString(),
                        address = address.getText().toString(),
                        phone = phoneNumber.getText().toString(),
                        password = password.getText().toString()).value!!

                    if(data.token != null){
                        SPrefs!!.usertoken = data.token
                        SPrefs.name = username.getText().toString()
                    }

                    if (SPrefs!!.usertoken != "") {

                        Toast.makeText(context, "Sign up was successful", Toast.LENGTH_SHORT).show()
                        view.findNavController().navigate(R.id.allRecipeFragment)
                    }
                }

            } else {

                Toast.makeText(context, "Sorry. No internet connection", Toast.LENGTH_SHORT).show()
            }
        }

        login.setOnClickListener {

            it.findNavController().navigate(R.id.loginFragment)
        }
    }

    private fun collectSignupProfileData(): Boolean {

        val email : String = email.getText().toString()

        if (username.getText().toString() == "") {

            Toast.makeText(context, "Username required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.equals("", ignoreCase = true)) {

            Toast.makeText(context, "Email required", Toast.LENGTH_SHORT).show()
            return false

        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            Toast.makeText(context, "Invalide email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (address.getText().toString() == "") {

            Toast.makeText(context, "Address required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (phoneNumber.getText().toString() == "") {

            Toast.makeText(context, "Phone required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.getText().toString() == "") {

            Toast.makeText(context, "Password required", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}