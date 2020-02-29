package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.repository.Repository
import juanocampo.test.domain.state.*

class FlipCardUseCase(val repository: Repository) {

    operator fun invoke(memoryGame: MemoryGame, positionToFlip: Int): FlipStatus {

        val cardToFlip = memoryGame.gameCardList[positionToFlip]
        cardToFlip.isRevealed = true
        val otherCard = memoryGame.getLastRevealedGameCard()

        return when {
            otherCard == null -> {
                memoryGame.lastRevealedPosition = positionToFlip
                CardRevealed
            }
            cardToFlip.isRevealed && otherCard.isRevealed && otherCard.cardId == cardToFlip.cardId-> {
                cardToFlip.isFlip = true
                otherCard.isFlip = true
                memoryGame.resetLastCardRevealed()
                val user = repository.load()
                user.matchedCards.add(otherCard.cardId)
                repository.saveUser(user)
                return Match
            }
            else-> {
                memoryGame.resetLastCardRevealed()
                cardToFlip.isRevealed = false
                otherCard.isRevealed = false
                NonMatch
            }
        }
    }

    fun didWonTheGame(memoryGame: MemoryGame): GameStatus {
        val flipedCount = memoryGame.getFlipedCount()
        val isGameWon = flipedCount == memoryGame.gameCardList.size
        return if (isGameWon) WonGame else GamePlay
    }
}