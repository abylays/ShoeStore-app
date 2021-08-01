package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel() : ViewModel() {

    private var _loginState = MutableLiveData<Boolean>()
    val loginState : LiveData<Boolean>
        get() = _loginState

    init {
        _loginState.value = false
    }

    fun onLogin() {
        _loginState.value = true
    }

}