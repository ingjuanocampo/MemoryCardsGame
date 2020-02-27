package juanocampo.test.memoryflipgame.presentation.viewmodel.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.state.*
import juanocampo.test.domain.usecase.FlipCardUseCase
import juanocampo.test.domain.usecase.LoadGameUseCase
import juanocampo.test.memoryflipgame.presentation.entities.GameCardViewType
import juanocampo.test.memoryflipgame.presentation.viewmodel.*
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class GameViewModel(
    private val loadGameUseCase: LoadGameUseCase,
    private val flipCardUseCase: FlipCardUseCase
) : ViewModel(),
    CoroutineScope {

    private var memoryGame: MemoryGame? = null
    private val job: Job = Job()


    val gameScreenStatusLiveData = MutableLiveData<GameScreenStatus>()

    fun loadGame() = launch {
        when (val gameResult = loadGameUseCase()) {
            is SuccessState -> {
                gameScreenStatusLiveData.postValue(GameLoaded(gameResult.data.gameCardList.map {
                    GameCardViewType(
                        it.id,
                        it.imageRes,
                        it.isFlip)
                }, gameResult.data.grid))
                memoryGame = gameResult.data
            }
            else -> gameScreenStatusLiveData.postValue(GameError)
        }
    }

    fun flipCard(positionToFlip: Int) = launch {

        if (memoryGame != null) {
            when (flipCardUseCase(memoryGame!!, positionToFlip)) {
                is CardRevealed -> {
                }
                is WonGame -> gameScreenStatusLiveData.postValue(WonGameScreen)
                is Match -> gameScreenStatusLiveData.postValue(MatchScreen)
                is NonMatch -> {
                    delay(TimeUnit.SECONDS.toMillis(3))
                    gameScreenStatusLiveData.postValue(NonMatchScreen)
                }
            }
        } else {
            gameScreenStatusLiveData.postValue(GameError)
        }
    }


    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}