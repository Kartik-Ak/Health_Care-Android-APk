package com.example.healthcare.DataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_prefs")

class DataStoreManager(private val context: Context) {

    private val FIRST_NAME_KEY = stringPreferencesKey("first_name")
    private val SECOND_NAME_KEY = stringPreferencesKey("second_name")
    private val AGE_KEY = stringPreferencesKey("age")
    private val HEIGHT_KEY = stringPreferencesKey("height")
    private val WEIGHT_KEY = stringPreferencesKey("weight")
    private val GENDER_KEY = stringPreferencesKey("gender")
    private val BLOOD_GROUP_KEY = stringPreferencesKey("blood_group")

    val firstNameFlow: Flow<String> = context.dataStore.data.map { it[FIRST_NAME_KEY] ?: "" }
    val secondNameFlow: Flow<String> = context.dataStore.data.map { it[SECOND_NAME_KEY] ?: "" }
    val ageFlow: Flow<String> = context.dataStore.data.map { it[AGE_KEY] ?: "" }
    val heightFlow: Flow<String> = context.dataStore.data.map { it[HEIGHT_KEY] ?: "" }
    val weightFlow: Flow<String> = context.dataStore.data.map { it[WEIGHT_KEY] ?: "" }
    val genderFlow: Flow<String> = context.dataStore.data.map { it[GENDER_KEY] ?: "" }
    val bloodGroupFlow: Flow<String> = context.dataStore.data.map { it[BLOOD_GROUP_KEY] ?: "" }

    suspend fun saveFirstName(value: String) = context.dataStore.edit { it[FIRST_NAME_KEY] = value }
    suspend fun saveSecondName(value: String) = context.dataStore.edit { it[SECOND_NAME_KEY] = value }
    suspend fun saveAge(value: String) = context.dataStore.edit { it[AGE_KEY] = value }
    suspend fun saveHeight(value: String) = context.dataStore.edit { it[HEIGHT_KEY] = value }
    suspend fun saveWeight(value: String) = context.dataStore.edit { it[WEIGHT_KEY] = value }
    suspend fun saveGender(value: String) = context.dataStore.edit { it[GENDER_KEY] = value }
    suspend fun saveBloodGroup(value: String) = context.dataStore.edit { it[BLOOD_GROUP_KEY] = value }
}

