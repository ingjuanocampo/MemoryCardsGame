package juanocampo.test.domain.repository

import juanocampo.test.domain.entity.GameCard
import juanocampo.test.domain.entity.GameOption
import juanocampo.test.domain.entity.User

interface Repository {

    fun saveUser(user: User)

    fun load(): User

    fun loadModeOptions(): List<GameOption>

    fun loadGameCards(): List<GameCard>

    fun clear()
}