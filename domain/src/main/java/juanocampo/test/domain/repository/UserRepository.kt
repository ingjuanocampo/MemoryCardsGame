package juanocampo.test.domain.repository

import juanocampo.test.domain.entity.User

interface UserRepository {

    fun save()

    fun load(): User?
}