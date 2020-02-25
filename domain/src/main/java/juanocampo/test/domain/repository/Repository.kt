package juanocampo.test.domain.repository

import juanocampo.test.domain.entity.User

interface Repository {

    fun save()

    fun load(): User?

    fun loadOptions: GameSettings
}