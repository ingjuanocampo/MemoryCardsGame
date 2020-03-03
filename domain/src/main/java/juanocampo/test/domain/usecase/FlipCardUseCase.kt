package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.repository.Repository
import juanocampo.test.domain.state.*

class FlipCardUseCase(val repository: Repository) {

    operator fun invoke(memoryGame: MemoryGame, positionToFlip: Int): FlipStatus {

        val cardToFlip = memoryGame.gameCardList[positionToFlip]
        if (cardToFlip.isRevealed) {
            return FlipDone
        }

        cardToFlip.isRevealed = true
        val otherCard = memoryGame.getLastRevealedGameCard()

        return when {
            otherCard == null -> {
                memoryGame.lastRevealedPosition = positionToFlip
                CardRevealed
            }
            cardToFlip.isRevealed && otherCard.isRevealed && otherCard.cardId == cardToFlip.cardId-> {
                memoryGame.gameCardList[cardToFlip.index].isFlip = true
                memoryGame.gameCardList[otherCard.index].isFlip = true
                memoryGame.gameCardList[cardToFlip.index].isRevealed = true
                memoryGame.gameCardList[otherCard.index].isRevealed = true
                memoryGame.resetLastCardRevealed()
                val user = repository.load()
                user.matchedCards.add(otherCard.cardId)
                repository.saveUser(user)
                return Match
            }
            else-> {
                memoryGame.resetLastCardRevealed()
                memoryGame.gameCardList[cardToFlip.index].isRevealed = false
                memoryGame.gameCardList[otherCard.index].isRevealed = false
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