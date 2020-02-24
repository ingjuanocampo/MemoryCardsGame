package juanocampo.test.data.di

import dagger.Module
import dagger.Provides
import juanocampo.test.data.UserRepositoryImpl
import juanocampo.test.domain.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun providesUserRepository(
    ): UserRepository = UserRepositoryImpl()



}