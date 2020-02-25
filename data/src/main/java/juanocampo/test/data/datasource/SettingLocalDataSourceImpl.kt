package juanocampo.test.data.datasource

import juanocampo.test.data.R
import juanocampo.test.data.repository.source.SettingLocalDataSource
import juanocampo.test.data.entity.GameCardCache


class SettingLocalDataSourceImpl: SettingLocalDataSource {

    override fun loadGameModes(): List<Pair<Int, Int>> {
        return listOf(Pair(3, 4), Pair(5, 2), Pair(4, 4), Pair(4, 5))
    }

    override fun loadGameCards(): List<GameCardCache>  = listOf(
        GameCardCache("1", R.drawable.bat),
        GameCardCache("2", R.drawable.chicken),
        GameCardCache("3", R.drawable.chicken),
        GameCardCache("4", R.drawable.cowd),
        GameCardCache("5", R.drawable.dragon),
        GameCardCache("6", R.drawable.ghost),
        GameCardCache("7", R.drawable.hourse),
        GameCardCache("8", R.drawable.man),
        GameCardCache("9", R.drawable.pig),
        GameCardCache("9", R.drawable.spider)
    )

}