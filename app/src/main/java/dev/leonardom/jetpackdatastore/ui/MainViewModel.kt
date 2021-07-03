package dev.leonardom.jetpackdatastore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leonardom.jetpackdatastore.data.datastore.SettingsDataStore
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val settingsDataStore: SettingsDataStore
): ViewModel() {

    val settingsPrefs = settingsDataStore.settingsPrefsFlow.asLiveData()

    fun toggleDarkMode(){
        viewModelScope.launch {
            settingsDataStore.toggleDarkTheme()
        }
    }

}