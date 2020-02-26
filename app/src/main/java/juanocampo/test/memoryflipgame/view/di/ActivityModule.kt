package juanocampo.test.memoryflipgame.view.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import juanocampo.test.memoryflipgame.view.lobby.MainActivity
import juanocampo.test.memoryflipgame.di.PresentationScope
import juanocampo.test.memoryflipgame.presentation.di.PresentationModule
import juanocampo.test.memoryflipgame.view.lobby.LobbyFragment


@Module
abstract class ActivityModule {

    @PresentationScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun mainActivity(): MainActivity

    @PresentationScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun lobbyFragment(): LobbyFragment


}