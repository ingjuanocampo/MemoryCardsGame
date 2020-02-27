package juanocampo.test.memoryflipgame.presentation.viewmodel
import juanocampo.test.memoryflipgame.presentation.entities.GameCardViewType

sealed class GameScreenStatus

data class GameLoaded(val gameList: List<GameCardViewType>,
                      val grid: Pair<Int, Int>): GameScreenStatus()
object WonGameScreen: GameScreenStatus()
data class FlipedScreen(val gameList: List<GameCardViewType>): GameScreenStatus()
data class MatchScreen(val gameList: List<GameCardViewType>): GameScreenStatus()
data class NonMatchScreen(val gameList: List<GameCardViewType>): GameScreenStatus()
object GameError: GameScreenStatus()
object GameEndScreen: GameScreenStatus()
