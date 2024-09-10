package com.carlostorres.borutodex.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.carlostorres.borutodex.data.pref.DataStoreOperationsImpl.PreferencesKey.onBoardingKey
import com.carlostorres.borutodex.domain.repository.DataStoreOperations
import com.carlostorres.borutodex.util.Constants.PREFERENCES_KEY
import com.carlostorres.borutodex.util.Constants.PREFERENCES_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException
import javax.inject.Inject

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl (
    context: Context
) : DataStoreOperations {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }
            .map { preferences->
                val onBoardingState = preferences[onBoardingKey] ?: false
                onBoardingState
            }
    }

}