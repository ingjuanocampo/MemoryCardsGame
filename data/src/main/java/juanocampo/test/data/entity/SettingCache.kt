package juanocampo.test.data.entity

import juanocampo.test.data.R


class SettingCache {

    val gamesMode: List<Pair<Int, Int>> = listOf(Pair(3, 4), Pair(5, 2), Pair(4,4), Pair(4, 5))

    val gamesCardList: List<GameCard>  = listOf(
        GameCard(1, R.drawable.bat),
        GameCard(2, R.drawable.chicken),
        GameCard(3, R.drawable.chicken),
        GameCard(4, R.drawable.cowd),
        GameCard(5, R.drawable.dragon),
        GameCard(6, R.drawable.ghost),
        GameCard(7, R.drawable.hourse),
        GameCard(8, R.drawable.man),
        GameCard(9, R.drawable.pig),
        GameCard(9, R.drawable.spider)
    )
}