package com.udacity.shoestore.screens.shoeListing

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding

class ShoeListingFragment:Fragment() {


    private val viewModel: ShoeListingViewModel by activityViewModels()


    private lateinit var binding: ShoeListingFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflate(inflater, R.layout.shoe_listing_fragment, container, false)

        viewModel.shoeList.observe(this as LifecycleOwner, Observer {

            for (shoe in viewModel.shoeList.value!!) {
                val inBinding = ShoeItemBinding.inflate(layoutInflater)
                inBinding.shoeItem = shoe
                binding.listLayout.addView(inBinding.root)
            }
        })


        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            view?.findNavController()?.navigate(R.id.loginFragment)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}


