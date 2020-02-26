package juanocampo.test.domain.state

sealed class GameStatus

object WonGame: GameStatus()
object FlipedCards: GameStatus()
object Match: GameStatus()
object NonMatch: GameStatus()