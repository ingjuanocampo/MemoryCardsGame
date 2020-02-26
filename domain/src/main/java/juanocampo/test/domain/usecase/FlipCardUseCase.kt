package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.repository.Repository
import juanocampo.test.domain.state.*

class FlipCardUseCase(val repository: Repository) {

    operator fun invoke(memoryGame: MemoryGame, positionToFlip: Int): GameStatus {

        val cardToFlip = memoryGame.gameCardList[positionToFlip]
        cardToFlip.isRevealed = true
        val otherCard = memoryGame.getLastRevealedGameCard()
        val flipedCount = memoryGame.getFlipedCount()
        val isGameWon = flipedCount == memoryGame.gameCardList.size

        return when {
            otherCard == null -> CardRevealed
            isGameWon -> WonGame
            cardToFlip.isRevealed && otherCard.isRevealed && otherCard.id == cardToFlip.id-> {
                val user = repository.load()
                user.matchedCards.add(otherCard.id)
                repository.saveUser(user)
                return Match
            }
            else-> NonMatch
        }
    }
}