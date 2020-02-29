package juanocampo.test.data.datasource

import android.content.Context
import android.content.SharedPreferences
import juanocampo.test.data.entity.UserCache
import juanocampo.test.data.repository.source.UserLocalDataSource
import java.lang.IllegalStateException

class UserLocalDataSourceImpl(context: Context): UserLocalDataSource {

    companion object {
        private const val USER_ID = "User_id"
        private const val SELECTED_MODE = "Selected_mode"
        private const val MATCHED_CARD = "Matched_cards"
    }

    private val preference: SharedPreferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)

    override fun saveUser(user: UserCache) {
        val edit = preference.edit()
        edit.putString(USER_ID, user.id)
        edit.putInt(SELECTED_MODE, user.selectedMode)
        edit.putStringSet(MATCHED_CARD, user.matchedCards.toMutableSet())
        edit.apply()
    }

    override fun load(): UserCache {
        val userId = preference.getString(USER_ID, "")
        val selectedMode = preference.getInt(SELECTED_MODE, 0)
        val matchedCards = preference.getStringSet(MATCHED_CARD, emptySet())
        if (userId!= null && matchedCards != null) {
            val arrayList = ArrayList<String>()
            arrayList.addAll(matchedCards)
            return UserCache(userId, selectedMode, arrayList)
        } else {
            throw IllegalStateException("Nothing stored")
        }
    }

    override fun clear() {
        val edit = preference.edit()
        edit.clear().apply()
    }
}