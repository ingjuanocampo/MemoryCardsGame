package juanocampo.test.data


import juanocampo.test.domain.entity.User
import juanocampo.test.domain.repository.Repository

internal class UserRepositoryImpl(): Repository {

    override fun save() {
    }

    override fun load(): User? {
        return null
    }
}