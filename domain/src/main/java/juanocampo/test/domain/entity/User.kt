package juanocampo.test.domain.entity

data class User(
    var id: String,
    var selectedGameOptionId: Int,
    var matchedCards: List<String>
)