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


    private  var flipJob: Job? = null
    private var memoryGame: MemoryGame? = null
    private val job: Job = Job()


    val gameScreenStatusLiveData = MutableLiveData<GameScreenStatus>()

    fun loadGame() = launch {
        when (val gameResult = loadGameUseCase()) {
            is SuccessState -> {
                memoryGame = gameResult.data
                val gameList = getGameList()
                gameScreenStatusLiveData.postValue(GameLoaded(gameList, gameResult.data.grid))
            }
            else -> gameScreenStatusLiveData.postValue(GameError)
        }
    }

    private fun getGameList(): List<GameCardViewType> {
        return memoryGame?.gameCardList?.map {
            GameCardViewType(
                it.cardId,
                it.imageRes,
                it.isFlip || it.isRevealed,
                it.index
            )
        } ?: emptyList()
    }

    fun flipCard(positionToFlip: Int) = launch {

        flipJob?.cancel()// Wait first re quest if there was

        flipJob = launch {
            doFliping(positionToFlip)
        }

    }

    private suspend fun doFliping(positionToFlip: Int) {
        if (memoryGame != null) {
            when (flipCardUseCase(memoryGame!!, positionToFlip)) {
                is CardRevealed -> gameScreenStatusLiveData.postValue(FlipedScreen(getGameList()))
                is WonGame -> gameScreenStatusLiveData.postValue(WonGameScreen)
                is Match -> gameScreenStatusLiveData.postValue(MatchScreen(getGameList()))
                is NonMatch -> {
                    delay(TimeUnit.SECONDS.toMillis(1))
                    val list = getGameList()
                    gameScreenStatusLiveData.postValue(NonMatchScreen(list))
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

    fun clearGame() = launch {
        loadGameUseCase.clear()
        gameScreenStatusLiveData.postValue(GameEndScreen)

    }
}