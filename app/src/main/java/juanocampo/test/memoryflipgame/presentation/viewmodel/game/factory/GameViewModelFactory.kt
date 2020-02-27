package juanocampo.test.memoryflipgame.presentation.viewmodel.game.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import juanocampo.test.domain.usecase.FlipCardUseCase
import juanocampo.test.domain.usecase.LoadGameUseCase
import juanocampo.test.memoryflipgame.presentation.viewmodel.game.GameViewModel

class GameViewModelFactory(private val loadGameUseCase: LoadGameUseCase,
                           private val flipCardUseCase: FlipCardUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (GameViewModel::class.java.isAssignableFrom(modelClass)) return GameViewModel(
            loadGameUseCase,
            flipCardUseCase
        ) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}