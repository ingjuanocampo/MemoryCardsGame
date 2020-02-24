package juanocampo.test.memoryflipgame.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import juanocampo.test.memoryflipgame.presentation.viewmodel.MainViewModel

class MainViewModelFactory(): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (MainViewModel::class.java.isAssignableFrom(modelClass)) return MainViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}