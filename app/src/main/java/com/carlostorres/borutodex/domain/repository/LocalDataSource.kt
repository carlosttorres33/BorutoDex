package com.carlostorres.borutodex.domain.repository

import com.carlostorres.borutodex.data.model.Hero

interface LocalDataSource {

    suspend fun getSelectedHero(heroID : Int) : Hero

}