package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.GameCard
import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.state.ErrorState
import juanocampo.test.domain.state.ResultState
import juanocampo.test.domain.state.SuccessState
import juanocampo.test.domain.repository.Repository
import java.lang.Exception

class LoadGameUseCase(private val repository: Repository) {

    operator fun invoke(): ResultState {
        return try {
            val user = repository.load()
            val gameCardList = repository.loadGameCards()
            val options = repository.loadModeOptions()
            val selectedGrid = options.first { it.id == user.selectedGameOptionId }
            val doubleCard = arrayListOf<GameCard>()
            doubleCard.addAll(gameCardList)
            doubleCard.addAll(gameCardList)
            doubleCard.shuffle()
            SuccessState(MemoryGame(selectedGrid.gridOption, doubleCard))
        } catch (e: Exception) {
            ErrorState(e)
        }
    }

}