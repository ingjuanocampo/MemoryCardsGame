package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.GameCard
import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.state.ErrorState
import juanocampo.test.domain.state.ResultState
import juanocampo.test.domain.state.SuccessState
import juanocampo.test.domain.repository.Repository
import java.lang.Exception

class LoadGameUseCase(private val repository: Repository) {

    operator fun invoke(): ResultState<MemoryGame> {
        return try {
            val user = repository.load()
            val gameCardList = repository.loadGameCards()
            val options = repository.loadModeOptions()
            val selectedGrid = options.first { it.id == user.selectedGameOptionId }
            var doubleCardList = arrayListOf<GameCard>()
            gameCardList.forEach {
                doubleCardList.add(it.copy())
                doubleCardList.add(it.copy())
            }
            doubleCardList.shuffle()

            doubleCardList.forEachIndexed { index, gameCard ->
                run {
                    gameCard.index = index
                }
            }
            SuccessState(MemoryGame(selectedGrid.gridOption, doubleCardList))
        } catch (e: Exception) {
            ErrorState(e)
        }
    }

    fun clear() {
        repository.clear()
    }

}