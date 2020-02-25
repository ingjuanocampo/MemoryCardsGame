package juanocampo.test.data.datasource.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import juanocampo.test.data.datasource.SettingLocalDataSourceImpl
import juanocampo.test.data.datasource.UserLocalDataSourceImpl
import juanocampo.test.data.repository.source.SettingLocalDataSource
import juanocampo.test.data.repository.source.UserLocalDataSource

@Module
class SourceModule {

    @Reusable
    @Provides
    fun providesLocalSettingDataSource(): SettingLocalDataSource = SettingLocalDataSourceImpl()

    @Reusable
    @Provides
    fun providesLocalUserDataSource(context: Context): UserLocalDataSource = UserLocalDataSourceImpl(context)

}