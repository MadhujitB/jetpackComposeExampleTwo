package com.example.composelogin.viewmodel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel(){
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var emailError by mutableStateOf<String?>(null)
    var passwordError by mutableStateOf<String?>(null)

    fun validate(): Boolean{
        var valid = true

        emailError = if (email.isBlank()){
            valid = false
            "Email cannot be empty"
        } else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            valid = false
            "Invalid email format"
        } else null

        passwordError = if (password.length < 6){
            valid = false
            "Password must be at least 6 characters"
        }  else null

        return valid
    }

    fun login(){
        if (validate()){

        }
    }
}