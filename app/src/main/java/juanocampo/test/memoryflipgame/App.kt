package juanocampo.test.memoryflipgame

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import juanocampo.test.memoryflipgame.di.AppComponent
import juanocampo.test.memoryflipgame.di.DaggerAppComponent
import javax.inject.Inject

class App: Application(), HasAndroidInjector {


    override fun androidInjector(): AndroidInjector<Any> {
        return activityDispatchingAndroidInjector
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
        component.inject(this)
    }


}