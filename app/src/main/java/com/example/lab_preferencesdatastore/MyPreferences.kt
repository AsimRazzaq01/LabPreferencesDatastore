package com.example.lab_preferencesdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.lab_preferencesdatastore.MyPreferences.PreferenceKeys.backColor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MyPreferences (val context: Context) {
    private object PreferenceKeys {
        val backColor: Preferences.Key<Long> = longPreferencesKey("backColor")
    }

    suspend fun updateBackColor(newBackColor: Long) =
        context.dataStore.edit { preferences: MutablePreferences ->
            preferences[backColor] = newBackColor
        }

    fun watchBackColor(): Flow<Long> = context.dataStore.data.map { preferences: Preferences ->
        return@map preferences[backColor] ?: 0xFFFF00FF
    }

}