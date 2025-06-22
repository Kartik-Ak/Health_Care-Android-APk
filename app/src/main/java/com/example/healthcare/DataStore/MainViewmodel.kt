package com.example.healthcare.DataStore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val dataStoreManager = DataStoreManager(application.applicationContext)

    val firstName = dataStoreManager.firstNameFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")
    val secondName = dataStoreManager.secondNameFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")
    val age = dataStoreManager.ageFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")
    val height = dataStoreManager.heightFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")
    val weight = dataStoreManager.weightFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")
    val gender = dataStoreManager.genderFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")
    val bloodGroup = dataStoreManager.bloodGroupFlow.stateIn(viewModelScope, SharingStarted.Lazily, "")

    fun saveFirstName(value: String) = viewModelScope.launch { dataStoreManager.saveFirstName(value) }
    fun saveSecondName(value: String) = viewModelScope.launch { dataStoreManager.saveSecondName(value) }
    fun saveAge(value: String) = viewModelScope.launch { dataStoreManager.saveAge(value) }
    fun saveHeight(value: String) = viewModelScope.launch { dataStoreManager.saveHeight(value) }
    fun saveWeight(value: String) = viewModelScope.launch { dataStoreManager.saveWeight(value) }
    fun saveGender(value: String) = viewModelScope.launch { dataStoreManager.saveGender(value) }
    fun saveBloodGroup(value: String) = viewModelScope.launch { dataStoreManager.saveBloodGroup(value) }
}

