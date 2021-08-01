package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoeListing.ShoeListingViewModel
import com.udacity.shoestore.screens.shoeListing.State

class ShoeDetailFragment:Fragment() {


    private val viewModel: ShoeListingViewModel by activityViewModels()

    private  val shoeItem = Shoe("", 0.0, "", "")

    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)

        binding.shoeListingViewModel = viewModel
        binding.lifecycleOwner = this
        binding.shoeItem = shoeItem

        binding.buttonCancel.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        }

        viewModel.state.observe(this as LifecycleOwner, Observer{ st ->
            when(st) {
                State.SAVED -> {
                    navigateToShoeList()
                    viewModel.onSaveCompleted()
                }
            }
        })
        return binding.root
    }

    private  fun navigateToShoeList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment()
        findNavController().navigate(action)

    }
}