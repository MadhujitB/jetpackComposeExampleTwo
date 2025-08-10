package com.example.composelogin.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composelogin.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()){
    val email = viewModel.email
    val password = viewModel.password
    val emailError = viewModel.emailError
    val passwordError = viewModel.passwordError

    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {viewModel.email = it},
            label = {Text("Email")},
            isError = emailError != null,
            modifier = Modifier.fillMaxWidth()
        )

        if (emailError != null){
            Text(emailError, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {viewModel.password = it},
            label = {Text("Password")},
            isError = passwordError != null,
            modifier = Modifier.fillMaxWidth()
        )

        if (passwordError != null){
            Text(passwordError, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {viewModel.login()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}