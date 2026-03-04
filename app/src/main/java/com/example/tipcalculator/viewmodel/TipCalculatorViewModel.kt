package com.example.tipcalculator.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TipCalculatorViewModel: ViewModel() {
    private val _amountInput = MutableStateFlow("")
    val amountInput: StateFlow<String> = _amountInput.asStateFlow()

    private val _tipInput = MutableStateFlow("")
    val tipInput: StateFlow<String> = _tipInput.asStateFlow()

    private val _roundUp = MutableStateFlow(false)
    val roundUp: StateFlow<Boolean> = _roundUp.asStateFlow()

    private val _person = MutableStateFlow(1)
    val person: StateFlow<Int> = _person.asStateFlow()

    fun updateAmount(value: String) {
        _amountInput.value = value
    }

    fun updateTip(value: String) {
        _tipInput.value = value
    }

    fun updateRoundUp(value: Boolean) {
        _roundUp.value = value
    }

    fun increasePerson() {
        _person.value += 1
    }

    fun decreasePerson() {
        if (_person.value > 1) {
            _person.value -= 1
        }
    }
}