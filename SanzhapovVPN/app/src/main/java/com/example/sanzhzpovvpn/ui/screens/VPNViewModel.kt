package com.example.sanzhzpovvpn.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface VPNUiState {
    object Success : VPNUiState
    object Loading : VPNUiState
    object Error : VPNUiState
}

class VPNViewModel : ViewModel() {
     var vpnUiState: VPNUiState by mutableStateOf(VPNUiState.Loading)
         private set

    init {
        connectToVPNServer()
    }

    fun connectToVPNServer() {
        viewModelScope.launch {
            vpnUiState = try {
                VPNUiState.Success
            } catch (e: IOException) {
                VPNUiState.Error
            }
        }
    }

}