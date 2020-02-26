package juanocampo.test.domain.state

sealed class GameStatus

object WonGame: GameStatus()
object CardRevealed: GameStatus()
object Match: GameStatus()
object NonMatch: GameStatus()