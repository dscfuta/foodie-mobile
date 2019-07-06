package mobile.dscfuta.foodie.authentication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.login
import kotlinx.android.synthetic.main.fragment_login.password
import kotlinx.android.synthetic.main.fragment_login.username

import mobile.dscfuta.foodie.R
import mobile.dscfuta.foodie.viewmodel.CustomViewModel


class LoginFragment : Fragment() {

    lateinit var customViewModel: CustomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customViewModel = CustomViewModel()

        login.setOnClickListener {

            if(collectLoginProfileData()){
//                customViewModel.login()

            }
        }

        signup.setOnClickListener {

            it.findNavController().navigate(R.id.signUpFragment)
        }
    }

    private fun collectLoginProfileData(): Boolean {

        if (username.getText().toString() == "") {

            Toast.makeText(context, "Username required", Toast.LENGTH_SHORT).show()

            return false
        }

        if (password.getText().toString() == "") {

            Toast.makeText(context, "Password required", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

}