package juanocampo.test.domain.entity

data class GameCard(val id: String, val imageRes: Int, var isFlip: Boolean, var isRevealed: Boolean = false)