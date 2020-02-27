package juanocampo.test.memoryflipgame.presentation.viewmodel

import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.memoryflipgame.presentation.entities.GameCardViewType

sealed class GameScreenStatus

data class GameLoaded(val gameList: List<GameCardViewType>,
                      val grid: Pair<Int, Int>): GameScreenStatus()
object WonGameScreen: GameScreenStatus()
object MatchScreen: GameScreenStatus()
object NonMatchScreen: GameScreenStatus()
object GameError: GameScreenStatus()
