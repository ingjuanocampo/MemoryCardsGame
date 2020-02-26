package juanocampo.test.memoryflipgame.presentation.entities

sealed class LobbyScreenStatus

data class OptionsLoaded(val options: List<GameOptionViewType>): LobbyScreenStatus()
object OptionSaved : LobbyScreenStatus()
object OptionError: LobbyScreenStatus()