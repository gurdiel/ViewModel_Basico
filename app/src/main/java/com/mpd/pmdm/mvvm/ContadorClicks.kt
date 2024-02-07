package com.mpd.pmdm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContadorClicks(valorContador: Int) : ViewModel() {

    private val _cuentaClicks = MutableLiveData<Int>(valorContador)
    val cuentaClicks: LiveData<Int> = _cuentaClicks

    var nombre = MutableLiveData<String>("")


    fun incrementa() {
        _cuentaClicks.value = cuentaClicks.value?.plus(1)
        nombre.value = nombre.value.plus(" el incrementador.")

    }

    fun decrementa() {
        _cuentaClicks.value = cuentaClicks.value?.minus(1)
    }
}

class ContadorClickFactory(val valor: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContadorClicks(valor) as T
    }
}