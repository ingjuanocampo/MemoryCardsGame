package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.GameOption
import juanocampo.test.domain.state.ErrorState
import juanocampo.test.domain.state.ResultState
import juanocampo.test.domain.state.SuccessState
import juanocampo.test.domain.repository.Repository

class LoadOptionUseCase(private val repository: Repository) {


    operator fun invoke(): ResultState<List<GameOption>> {
        return try {
            val gameOptions = repository.loadModeOptions()
            if (gameOptions.isNotEmpty()) {
                SuccessState(gameOptions)
            } else {
                ErrorState(IllegalStateException("Not options"))
            }
        } catch (e: Exception) {
            ErrorState(e)
        }
    }

}