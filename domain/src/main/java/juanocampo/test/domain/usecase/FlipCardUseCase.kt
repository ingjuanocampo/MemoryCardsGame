package juanocampo.test.domain.usecase

import juanocampo.test.domain.entity.GameCard
import juanocampo.test.domain.entity.MemoryGame
import juanocampo.test.domain.state.FlipedCards
import juanocampo.test.domain.state.GameStatus
import juanocampo.test.domain.state.Match

class FlipCardUseCase {

    operator fun invoke(memoryGame: MemoryGame, postionToFlip: Int): GameStatus {
        val copyGameList = ArrayList<GameCard>()
        copyGameList.addAll(copyGameList)

        val cardToFlip = copyGameList[postionToFlip]
        cardToFlip.isRevealed = true
        copyGameList.remove(cardToFlip)


        val otherCard = copyGameList.first { it.id ==  cardToFlip.id }

        return when {
            cardToFlip.isRevealed && otherCard.isRevealed -> Match

            cardToFlip.isRevealed && !otherCard.isRevealed -> FlipedCards


        }



    }
}