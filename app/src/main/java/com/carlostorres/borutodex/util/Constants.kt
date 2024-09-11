package com.carlostorres.borutodex.util

import androidx.datastore.preferences.core.booleanPreferencesKey

object Constants {

    const val DETAILS_ARGUMENT_KEY = "heroID"

    const val HERO_DATABASE_TABLE = "hero_table"
    const val HERO_REMOTE_KEYS_DATABASE_TABLE = "hero_remote_keys_table"
    const val BORUTO_DATABASE = "boruto_database"

    const val LAST_ON_BOARDING_PAGE = 2
    const val ITEMS_PER_PAGE = 3

    const val PREFERENCES_NAME : String = "boruto_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    const val SEARCH_HEROES_ENDPOINT = "/boruto/heroes/search"
    const val GET_ALL_HEROES_ENDPOINT = "/boruto/heroes"
    const val BASE_URL = "http://10.0.2.2:8080"

}