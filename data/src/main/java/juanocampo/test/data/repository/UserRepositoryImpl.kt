package juanocampo.test.data.repository


import juanocampo.test.data.entity.UserCache
import juanocampo.test.data.repository.source.SettingLocalDataSource
import juanocampo.test.data.repository.source.UserLocalDataSource
import juanocampo.test.domain.entity.GameCard
import juanocampo.test.domain.entity.User
import juanocampo.test.domain.repository.Repository

internal class UserRepositoryImpl(
    private val settingLocalDataSource: SettingLocalDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : Repository {

    override fun saveUser(user: User) {
        userLocalDataSource.saveUser(UserCache(user.id, user.selectedMode, user.matchedCards))
    }

    override fun load(): User {
        val userCache = userLocalDataSource.load()
        return User(userCache.id, userCache.selectedMode, userCache.matchedCards)
    }

    override fun loadModeOptions(): List<Pair<Int, Int>> {
        return settingLocalDataSource.loadGameModes()
    }

    override fun loadGameCards(): List<GameCard> {
        val user = load()
        return settingLocalDataSource.loadGameCards().map {
            return@map GameCard(
                it.id, it.imageRes,
                user.matchedCards.contains(it.id)
            )
        }
    }
}