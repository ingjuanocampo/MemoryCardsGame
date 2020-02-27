package juanocampo.test.memoryflipgame.presentation.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.usecase.FlipCardUseCase
import juanocampo.test.domain.usecase.LoadGameUseCase
import juanocampo.test.domain.usecase.LoadOptionUseCase
import juanocampo.test.domain.usecase.SaveSelectedGameOptionUseCase
import juanocampo.test.memoryflipgame.di.PresentationScope
import juanocampo.test.memoryflipgame.presentation.viewmodel.game.factory.GameViewModelFactory
import juanocampo.test.memoryflipgame.presentation.viewmodel.lobby.factory.LobbyViewModelFactory

@Module
class PresentationModule {

    @PresentationScope
    @Provides
    fun providesMainViewModelFactory(
        loadOptionUseCase: LoadOptionUseCase,
        saveSelectedGameOptionUseCase: SaveSelectedGameOptionUseCase
    ) = LobbyViewModelFactory(
        loadOptionUseCase,
        saveSelectedGameOptionUseCase
    )

    @PresentationScope
    @Provides
    fun providesGameVieModelFactory(
        loadGameUseCase: LoadGameUseCase,
        flipCardUseCase: FlipCardUseCase
    ) = GameViewModelFactory(loadGameUseCase, flipCardUseCase)


}