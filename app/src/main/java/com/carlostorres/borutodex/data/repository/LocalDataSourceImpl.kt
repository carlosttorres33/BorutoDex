package com.carlostorres.borutodex.data.repository

import com.carlostorres.borutodex.data.local.BorutoDatabase
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.domain.repository.LocalDataSource

class LocalDataSourceImpl (
    borutoDatabase: BorutoDatabase
) : LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroID: Int): Hero {
        return heroDao.getSelectedHero(heroID)
    }

}