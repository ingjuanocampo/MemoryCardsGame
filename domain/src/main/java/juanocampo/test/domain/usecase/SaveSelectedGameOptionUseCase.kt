package juanocampo.test.domain.usecase

import juanocampo.test.domain.state.ErrorState
import juanocampo.test.domain.state.ResultState
import juanocampo.test.domain.state.SuccessState
import juanocampo.test.domain.repository.Repository

class SaveSelectedGameOptionUseCase(private val repository: Repository) {

    operator fun invoke(gameOptionId: Int): ResultState {
        return try {
            val user = repository.load()
            user.selectedGameOptionId = gameOptionId
            repository.saveUser(user)
            SuccessState(true)
        } catch (e: Exception) {
            ErrorState(e)
        }
    }
}