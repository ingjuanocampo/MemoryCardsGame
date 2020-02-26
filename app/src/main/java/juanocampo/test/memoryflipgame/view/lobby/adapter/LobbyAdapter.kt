package juanocampo.test.memoryflipgame.view.lobby.adapter

import androidx.collection.SparseArrayCompat
import juanocampo.test.memoryflipgame.presentation.entities.GameOptionViewType
import juanocampo.test.memoryflipgame.presentation.entities.ViewTypes
import juanocampo.test.memoryflipgame.view.base.delegate.BaseAdapter
import juanocampo.test.memoryflipgame.view.base.delegate.appendDelegate

class LobbyAdapter(private val onGameSettingSelected: (GameOptionViewType)-> Unit): BaseAdapter() {

    init {
        delegateAdapters = SparseArrayCompat(1)
        delegateAdapters.appendDelegate(ViewTypes.GAME_OPTION_SETTING.ordinal, LobbyDelegateAdapter(onGameSettingSelected))
    }

}