package juanocampo.test.memoryflipgame.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import juanocampo.test.domain.usecase.LoadOptionUseCase
import juanocampo.test.domain.usecase.SaveSelectedGameOptionUseCase
import juanocampo.test.memoryflipgame.presentation.viewmodel.LobbyViewModel

class LobbyViewModelFactory(private val loadOptionUseCase: LoadOptionUseCase,
                            private val saveSelectedGameOptionUseCase: SaveSelectedGameOptionUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (LobbyViewModel::class.java.isAssignableFrom(modelClass)) return LobbyViewModel(loadOptionUseCase,
            saveSelectedGameOptionUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}