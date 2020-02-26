package juanocampo.test.data.di

import dagger.Module
import dagger.Provides
import juanocampo.test.data.datasource.di.SourceModule
import juanocampo.test.data.repository.UserRepositoryImpl
import juanocampo.test.data.repository.source.SettingLocalDataSource
import juanocampo.test.data.repository.source.UserLocalDataSource
import juanocampo.test.domain.repository.Repository

@Module(includes = [SourceModule::class])
class DataModule {

    @Provides
    fun providesUserRepository(settingLocalDataSource: SettingLocalDataSource, userLocalDataSource: UserLocalDataSource
    ): Repository = UserRepositoryImpl(settingLocalDataSource, userLocalDataSource)
}