package com.prokopenko.littlelemon.data

import android.content.Context
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import com.prokopenko.littlelemon.data.model.User
import kotlinx.coroutines.flow.flow

class PreferenceRepository(
    context: Context
) {
    private val userPref =
        context.getSharedPreferences(USER_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
    companion object {
        const val USER_PREFERENCE_FILE_KEY = "user_preference_file"

        const val USER_FIRST_NAME = "user_first_name"
        const val USER_LAST_NAME = "user_second_name"
        const val USER_EMAIL = "user_email"
        const val IS_USER_LOGGED_IN = "is_user_logged_in"
    }

    suspend fun saveUser(user: User): Boolean = withContext(Dispatchers.IO) {
        with(userPref.edit()) {

            putString(USER_FIRST_NAME, user.firstName)
            putString(USER_LAST_NAME, user.lastName)
            putString(USER_EMAIL, user.email)

            if (commit()) {
                putBoolean(IS_USER_LOGGED_IN, true)
                apply()
                return@withContext true
            } else return@withContext false
        }
    }

    fun isUserLoggedIn(): Boolean {
        return userPref.getBoolean(IS_USER_LOGGED_IN, false)
    }

    fun getUser() = flow {
        emit(
            User(
                firstName = userPref.getString(USER_FIRST_NAME, "") ?:return@flow,
                lastName = userPref.getString(USER_LAST_NAME,"") ?:return@flow,
                email = userPref.getString(USER_EMAIL, "") ?: return@flow
            )
        )
    }

    suspend fun clearUser() : Boolean = withContext(Dispatchers.IO) {
        with(userPref.edit()) {
            clear()
            return@with commit()
        }
    }
}