package juanocampo.test.domain.entity

class MemoryGame(val grid: Pair<Int, Int>,
                 val gameCardList: List<GameCard>,
                 var lastRevealedPosition: Int = -1) {

    fun getLastRevealedGameCard(): GameCard? {
        return if (lastRevealedPosition >= 0) gameCardList[lastRevealedPosition] else null
    }

    fun getFlipedCount(): Int {
        var flipedCount = 0
        gameCardList.forEachIndexed { index, gameCard ->
            if(gameCard.isFlip) {
                flipedCount++
            }
        }
        return flipedCount
    }

}