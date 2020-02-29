package juanocampo.test.domain.state

sealed class GameStatus

object WonGame: GameStatus()
object GamePlay: GameStatus()