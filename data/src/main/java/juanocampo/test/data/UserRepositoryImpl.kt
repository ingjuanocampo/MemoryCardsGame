package juanocampo.test.data


import juanocampo.test.domain.entity.User
import juanocampo.test.domain.repository.UserRepository

internal class UserRepositoryImpl(): UserRepository {

    override fun save() {
    }

    override fun load(): User? {
        return null
    }
}