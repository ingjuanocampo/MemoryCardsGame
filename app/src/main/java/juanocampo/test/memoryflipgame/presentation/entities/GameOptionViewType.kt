package juanocampo.test.memoryflipgame.presentation.entities

import juanocampo.test.memoryflipgame.view.base.delegate.RecyclerViewType

class GameOptionViewType(val description: String, val id: Int): RecyclerViewType {

    override fun getDelegateId(): Int {
        return id
    }

    override fun getViewType(): Int {
        return ViewTypes.GAME_OPTION_SETTING.ordinal
    }
}