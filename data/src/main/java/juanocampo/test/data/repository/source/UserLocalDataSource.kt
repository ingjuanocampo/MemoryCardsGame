package juanocampo.test.data.repository.source

import juanocampo.test.data.entity.UserCache

interface UserLocalDataSource {

    fun saveUser(user: UserCache)

    fun load(): UserCache

    fun clear()
}