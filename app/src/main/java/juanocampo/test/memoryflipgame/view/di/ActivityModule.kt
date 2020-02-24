package juanocampo.test.memoryflipgame.view.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import juanocampo.test.memoryflipgame.view.main.MainActivity
import juanocampo.test.memoryflipgame.di.PresentationScope
import juanocampo.test.memoryflipgame.presentation.di.PresentationModule


@Module
abstract class ActivityModule {

    @PresentationScope
    @ContributesAndroidInjector(modules = [PresentationModule::class])
    abstract fun mainActivity(): MainActivity


}