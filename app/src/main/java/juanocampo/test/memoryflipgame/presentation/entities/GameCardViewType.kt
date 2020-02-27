package juanocampo.test.memoryflipgame.presentation.entities

import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.view.base.delegate.RecyclerViewType

data class GameCardViewType(val id: String, private val imageRes: Int, val isRevealed: Boolean): RecyclerViewType {

    fun getImageResource(): Int {
        return if (isRevealed) imageRes else R.drawable.card_back
    }

    override fun getDelegateId(): Int {
        return id.hashCode()
    }

    override fun getViewType(): Int {
        return ViewTypes.GAME_CARD.ordinal
    }

}