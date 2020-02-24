package juanocampo.test.memoryflipgame.presentation.di

import dagger.Module
import dagger.Provides
import juanocampo.test.memoryflipgame.di.PresentationScope
import juanocampo.test.memoryflipgame.presentation.viewmodel.factory.MainViewModelFactory

@Module()
class PresentationModule {

    @PresentationScope
    @Provides
    fun providesMainViewModelFactory() = MainViewModelFactory()


}