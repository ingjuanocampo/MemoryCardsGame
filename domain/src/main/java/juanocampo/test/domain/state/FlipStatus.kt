package juanocampo.test.domain.state

sealed class FlipStatus

object CardRevealed: FlipStatus()
object Match: FlipStatus()
object NonMatch: FlipStatus()
object FlipDone: FlipStatus()