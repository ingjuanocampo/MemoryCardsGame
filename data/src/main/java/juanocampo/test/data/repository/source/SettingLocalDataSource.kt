package juanocampo.test.data.repository.source

import juanocampo.test.data.entity.GameCardCache

interface SettingLocalDataSource {

    fun loadGameModes(): List<Pair<Int, Int>>

    fun loadGameCards(): List<GameCardCache>

}