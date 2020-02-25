package juanocampo.test.data.di

import dagger.Module
import dagger.Provides
import juanocampo.test.data.repository.UserRepositoryImpl
import juanocampo.test.domain.repository.Repository

@Module
class DataModule {

    @Provides
    fun providesUserRepository(
    ): Repository = UserRepositoryImpl()



}