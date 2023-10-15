package com.example.animation.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animation.data.UserRepository
import com.example.animation.data.pref.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
}