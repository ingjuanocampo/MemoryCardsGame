package juanocampo.test.memoryflipgame.presentation.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.usecase.LoadOptionUseCase
import juanocampo.test.domain.usecase.SaveSelectedGameOptionUseCase
import juanocampo.test.memoryflipgame.di.PresentationScope
import juanocampo.test.memoryflipgame.presentation.viewmodel.factory.LobbyViewModelFactory

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


}