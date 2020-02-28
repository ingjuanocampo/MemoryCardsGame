package juanocampo.test.memoryflipgame.presentation.entities

import juanocampo.test.memoryflipgame.R
import juanocampo.test.memoryflipgame.view.base.delegate.RecyclerViewType

data class GameCardViewType(val id: String, private val imageRes: Int, var isRevealed: Boolean, val index: Int): RecyclerViewType {

    fun getImageResource(): Int {
        return if (isRevealed) imageRes else R.drawable.card_back
    }

    override fun getDelegateId(): Int {
        return index
    }

    override fun getViewType(): Int {
        return ViewTypes.GAME_CARD.ordinal
    }

    override fun equals(other: Any?): Boolean {
        return if (other is GameCardViewType) {
            other.id.compareTo(id) == 0 && other.isRevealed == isRevealed
        } else {
            false
        }
    }

}