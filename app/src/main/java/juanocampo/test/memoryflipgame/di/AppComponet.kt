package juanocampo.test.memoryflipgame.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import juanocampo.test.data.di.DataModule
import juanocampo.test.domain.di.DomainModule
import juanocampo.test.memoryflipgame.App
import juanocampo.test.memoryflipgame.view.di.ActivityModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    DomainModule::class,
    DataModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /**
     * Do not expose any provides here from another layer.
     *
     */

    fun inject(app: App)
}