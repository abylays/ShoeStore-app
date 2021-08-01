package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.OnboardingFragmentBinding

class OnboardingFragment: Fragment() {


    private lateinit var binding: OnboardingFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.onboarding_fragment, container, false)


        binding.instructionsButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_onboardingFragment_to_instructionsFragment)
        }

        return binding.root
    }


}