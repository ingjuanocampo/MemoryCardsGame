package juanocampo.test.memoryflipgame.view.game.adapter

import androidx.collection.SparseArrayCompat
import juanocampo.test.memoryflipgame.presentation.entities.GameCardViewType
import juanocampo.test.memoryflipgame.presentation.entities.ViewTypes
import juanocampo.test.memoryflipgame.view.base.delegate.BaseAdapter
import juanocampo.test.memoryflipgame.view.base.delegate.appendDelegate

class GameCardAdapter(private val onGameCardSelected: (GameCardViewType)-> Unit): BaseAdapter() {

    init {
        delegateAdapters = SparseArrayCompat(1)
        delegateAdapters.appendDelegate(
            ViewTypes.GAME_CARD.ordinal,
            GameCardDelegateAdapter(onGameCardSelected)
        )
    }

}