package juanocampo.test.memoryflipgame.presentation.viewmodel.lobby

import juanocampo.test.memoryflipgame.presentation.entities.GameOptionViewType

sealed class LobbyScreenStatus

data class OptionsLoaded(val options: List<GameOptionViewType>): LobbyScreenStatus()
object OptionSaved : LobbyScreenStatus()
object OptionError: LobbyScreenStatus()