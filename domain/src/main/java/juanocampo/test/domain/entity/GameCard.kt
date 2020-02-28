package juanocampo.test.domain.entity

data class GameCard(val cardId: String, val imageRes: Int, var isFlip: Boolean, var isRevealed: Boolean = false, var index: Int = 0)