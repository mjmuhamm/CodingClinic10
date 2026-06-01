package com.example.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingclinic10.com.example.domain.ModelRepository
import com.example.codingclinic10.com.example.domain.model.Model1
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository : ModelRepository) : ViewModel() {
    private val _state : MutableStateFlow<List<Model1>> = MutableStateFlow(emptyList())
    val state = _state.asStateFlow()

    init {
        getInfo()
    }

    fun getInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = repository.getInfo()
        }

    }


}