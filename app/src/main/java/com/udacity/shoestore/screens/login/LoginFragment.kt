package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.models.LoginViewModel

class LoginFragment: Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.login.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_email_24, 0, 0, 0)
        binding.password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_lock_24, 0, 0, 0)

        binding.buttonLogin.setOnClickListener {
            viewModel.onLogin()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
        }

        binding.buttonSignup.setOnClickListener {
            viewModel.onLogin()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
        }

        return binding.root
    }

}