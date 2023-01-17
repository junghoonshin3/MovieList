package com.sjh.movielist.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    sealed class Event {
        data class ShowToast(val text: String) : Event()
    }
}