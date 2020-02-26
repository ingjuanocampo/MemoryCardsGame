package juanocampo.test.domain.di

import dagger.Module
import dagger.Provides
import juanocampo.test.domain.repository.Repository
import juanocampo.test.domain.usecase.FlipCardUseCase
import juanocampo.test.domain.usecase.LoadGameUseCase
import juanocampo.test.domain.usecase.LoadOptionUseCase
import juanocampo.test.domain.usecase.SaveSelectedGameOptionUseCase

@Module
class DomainModule {

    @Provides
    fun providesFlipCardUseCase(repository: Repository) = FlipCardUseCase(repository)

    @Provides
    fun providesLoadGameUseCase(repository: Repository) = LoadGameUseCase(repository)

    @Provides
    fun providesLoadOptionUseCase(repository: Repository) = LoadOptionUseCase(repository)

    @Provides
    fun providesSaveSelectedGameOptionUseCase(repository: Repository) = SaveSelectedGameOptionUseCase(repository)

}