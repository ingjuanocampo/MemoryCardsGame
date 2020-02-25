package juanocampo.test.domain.entity

data class User(
    val id: String,
    val selectedMode: String,
    val matchedCards: List<String>
)