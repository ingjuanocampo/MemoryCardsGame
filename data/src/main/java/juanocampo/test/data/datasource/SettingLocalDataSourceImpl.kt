package juanocampo.test.data.datasource

import juanocampo.test.data.R
import juanocampo.test.data.repository.source.SettingLocalDataSource
import juanocampo.test.data.entity.GameCardCache


class SettingLocalDataSourceImpl: SettingLocalDataSource {

    override fun loadGameModes(): List<Pair<Int, Int>> {
        return listOf(Pair(3, 4), Pair(5, 2), Pair(4, 4), Pair(4, 5))
    }

    override fun loadGameCards(): List<GameCardCache>  = listOf(
        GameCardCache("bat", R.drawable.bat),
        GameCardCache("chicken", R.drawable.chicken),
        GameCardCache("cowd", R.drawable.cowd),
        GameCardCache("dragon", R.drawable.dragon),
        GameCardCache("ghost", R.drawable.ghost),
        GameCardCache("hourse", R.drawable.hourse),
        GameCardCache("man", R.drawable.man),
        GameCardCache("pig", R.drawable.pig),
        GameCardCache("spider", R.drawable.spider),
        GameCardCache("cat", R.drawable.cat)

    )

}