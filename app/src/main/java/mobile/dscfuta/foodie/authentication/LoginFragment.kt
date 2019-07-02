package mobile.dscfuta.foodie.authentication


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*

import mobile.dscfuta.foodie.R
import mobile.dscfuta.foodie.database.Login
import mobile.dscfuta.foodie.repository.Repository
import mobile.dscfuta.foodie.viewmodel.CustomViewModel


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)


        return view
    }


}
