package com.udacity.shoestore.screens.shoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

enum class State {
    SAVED,
    EMPTY
}

class ShoeListingViewModel :  ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _state = MutableLiveData<State>()
    val state : LiveData<State>
        get() = _state

    init {
        _shoeList.value = mutableListOf()
        addShoe("Nike Air Mercurial", 10.0, "Nike", "Football shoes")
        _state.value = State.EMPTY

    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        _shoeList.value?.add(Shoe(name, size, company, description))
    }

    fun onSave(name: String, size: String, company: String, description: String) {
        var sizeDouble : Double = 0.0
        try {
            sizeDouble = size.toDouble()
        } catch (e: NumberFormatException) {
            Timber.i("Invalid size entered")
        }
        addShoe(name, sizeDouble, company, description)
        _state.value = State.SAVED
    }
    fun onSaveCompleted() {
        _state.value = State.EMPTY
    }
}